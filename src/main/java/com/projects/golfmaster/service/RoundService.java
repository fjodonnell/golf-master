package com.projects.golfmaster.service;

import com.projects.golfmaster.exception.NotFoundException;
import com.projects.golfmaster.model.Round;
import com.projects.golfmaster.repository.RoundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RoundService {

    @Autowired
    RoundRepository roundRepository;

    public List<Round> getAllRounds() {
        List<Round> list = roundRepository.findAll();
        return list;
    }

    public Round getRoundById(UUID roundId) throws NotFoundException {
        Optional<Round> retrievedRound = roundRepository.findById(roundId);
        return retrievedRound.orElseThrow(() -> new NotFoundException("This round does not exist"));
    }

    public List<Round> getRoundsByEventName(String eventName) throws NotFoundException {
        Optional<List<Round>> retrievedRounds = roundRepository.findByEvent_EventName(eventName);
        return retrievedRounds.orElseThrow(() -> new NotFoundException("This event does not have any rounds"));
    }

    public Round createRound(Round round) {
        return roundRepository.save(round);
    }

    public Round updateRound(UUID roundId, Round round) throws NotFoundException {
        Optional<Round> retrievedRound = roundRepository.findById(roundId);
        if (retrievedRound.isPresent()) {
            Round existingRound = retrievedRound.get();
            existingRound.setRoundName(round.getRoundName());
            existingRound.setCourse(round.getCourse());
            existingRound.setEvent(round.getEvent());
            return roundRepository.save(existingRound);
        } else {
            throw new NotFoundException("The round you are trying to update does not exist");
        }
    }
}

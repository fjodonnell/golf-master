package com.projects.golfmaster.controller;

import com.projects.golfmaster.exception.NotFoundException;
import com.projects.golfmaster.model.Round;
import com.projects.golfmaster.service.RoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class RoundController implements RoundOperations {

    @Autowired
    RoundService roundService;

    @Override
    public List<Round> getAllRounds() {
        return roundService.getAllRounds();
    }

    @Override
    public Round getRoundById(UUID roundId) throws NotFoundException {
        return roundService.getRoundById(roundId);
    }

    @Override
    public List<Round> getRoundsByEventName(String eventName) throws NotFoundException {
        return roundService.getRoundsByEventName(eventName);
    }

    @Override
    public Round createRound(Round round) {
        return roundService.createRound(round);
    }

    @Override
    public Round updateRound(UUID roundId, Round round) throws NotFoundException {
        return roundService.updateRound(roundId, round);
    }
}

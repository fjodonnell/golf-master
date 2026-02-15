package com.projects.golfmaster.service;

import com.projects.golfmaster.model.Score;
import com.projects.golfmaster.exception.NotFoundException;
import com.projects.golfmaster.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@CacheConfig(cacheNames = "scores")
@Service
public class ScoreService {

    @Autowired
    ScoreRepository scoreRepository;

    public List<Score> getAllScores() {
        return scoreRepository.findAll();
    }

    public Score getScoreById(UUID scoreId) throws NotFoundException {
        Optional<Score> retrievedScore = scoreRepository.findById(scoreId);
        return retrievedScore.orElseThrow(() -> new NotFoundException("Score not found"));
    }
    @Cacheable
    public List<Score> getScoresByPlayer(String playerId) throws NotFoundException {
        Optional<List<Score>> retrievedScores = scoreRepository.findByPlayer_PlayerId(playerId);
        return retrievedScores.orElseThrow(() -> new NotFoundException("No scores found for the given player"));
    }
    @Cacheable
    public List<Score> getScoresByRound(UUID roundId) throws NotFoundException {
        Optional<List<Score>> retrievedScores = scoreRepository.findByRound_RoundId(roundId);
        return retrievedScores.orElseThrow(() -> new NotFoundException("No scores found for the given round"));
    }
    @Cacheable
    public List<Score> getScoresByMatch(UUID matchId) throws NotFoundException {
        Optional<List<Score>> retrievedScores = scoreRepository.findByMatch_MatchId(matchId);
        return retrievedScores.orElseThrow(() -> new NotFoundException("No scores found for the given match"));
    }
    @Cacheable
    public List<Score> getScoresByEvent(String eventName) throws NotFoundException {
        Optional<List<Score>> retrievedScores = scoreRepository.findByRound_Event_EventName(eventName);
        //Unwrap the optional in order to sort
        List<Score> scores = retrievedScores.orElseThrow(() -> new NotFoundException("No scores found for the given event"));
        // Sort by Round.roundNumber ascending
        scores.sort(Comparator.comparingInt(score -> score.getRound().getRoundNumber()));
        return scores;
    }

    @CacheEvict(allEntries = true)
    public Score createScore(Score score) {
        return scoreRepository.save(score);
    }

    @CacheEvict(allEntries = true)
    public Score updateScore(UUID scoreId, Score score) throws NotFoundException {
        Optional<Score> retrievedScore = scoreRepository.findById(scoreId);
        if (retrievedScore.isPresent()) {
            Score existingScore = retrievedScore.get();
            existingScore.setPlayer(score.getPlayer());
            existingScore.setRound(score.getRound());
            existingScore.setMatch(score.getMatch());
            existingScore.setScore(score.getScore());
            existingScore.setScoreToPar(score.getScoreToPar());
            existingScore.setPointsEarned(score.getPointsEarned());
            existingScore.setPars(score.getPars());
            existingScore.setBirdies(score.getBirdies());
            existingScore.setEagles(score.getEagles());
            return scoreRepository.save(existingScore);
        } else {
            throw new NotFoundException("The score you are trying to update does not exist");
        }
    }
}

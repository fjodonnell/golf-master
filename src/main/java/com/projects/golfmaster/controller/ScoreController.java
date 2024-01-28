package com.projects.golfmaster.controller;

import com.projects.golfmaster.exception.NotFoundException;
import com.projects.golfmaster.model.Score;
import com.projects.golfmaster.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class ScoreController implements ScoreOperations {

    @Autowired
    ScoreService scoreService;

    @Override
    public List<Score> getAllScores() {
        return scoreService.getAllScores();
    }

    @Override
    public Score getScoreById(UUID scoreId) throws NotFoundException {
        return scoreService.getScoreById(scoreId);
    }

    @Override
    public List<Score> getScoresByPlayer(String playerId) throws NotFoundException {
        return scoreService.getScoresByPlayer(playerId);
    }

    @Override
    public List<Score> getScoresByRound(UUID roundId) throws NotFoundException {
        return scoreService.getScoresByRound(roundId);
    }

    @Override
    public List<Score> getScoresByMatch(UUID matchId) throws NotFoundException {
        return scoreService.getScoresByMatch(matchId);
    }

    @Override
    public Score createScore(Score score) {
        return scoreService.createScore(score);
    }

    @Override
    public Score updateScore(UUID scoreId, Score score) throws NotFoundException {
        return scoreService.updateScore(scoreId, score);
    }
}

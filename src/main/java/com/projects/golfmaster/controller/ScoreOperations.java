package com.projects.golfmaster.controller;

import com.projects.golfmaster.exception.NotFoundException;
import com.projects.golfmaster.model.Score;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/score")
public interface ScoreOperations {

    @GetMapping("/")
    List<Score> getAllScores();

    @GetMapping("/{scoreId}")
    Score getScoreById(@PathVariable UUID scoreId) throws NotFoundException;

    @GetMapping("/playerId/{playerId}")
    List<Score> getScoresByPlayer(@PathVariable String playerId) throws NotFoundException;

    @GetMapping("/roundId/{roundId}")
    List<Score> getScoresByRound(@PathVariable UUID roundId) throws NotFoundException;

    @GetMapping("/matchId/{matchId}")
    List<Score> getScoresByMatch(@PathVariable UUID matchId) throws NotFoundException;

    @PostMapping("/create")
    Score createScore(@RequestBody Score score);

    @PutMapping("/{scoreId}")
    Score updateScore(@PathVariable UUID scoreId, @RequestBody Score score) throws NotFoundException;
}

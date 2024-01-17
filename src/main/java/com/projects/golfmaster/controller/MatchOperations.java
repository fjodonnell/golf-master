package com.projects.golfmaster.controller;

import com.projects.golfmaster.exception.MatchNotFoundException;
import com.projects.golfmaster.model.Match;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/match")
public interface MatchOperations {

    @GetMapping("/")
    List<Match> getAllMatches();

    @GetMapping("/{matchId}")
    Match getMatchById(@PathVariable UUID matchId) throws MatchNotFoundException;

//    @GetMapping("/{matchTeamWinner}")
//    List<Match> getMatchesWonByTeam(@PathVariable String teamName) throws MatchNotFoundException;

    @PostMapping("/create")
    Match createMatch(@RequestBody Match match);

//    @PutMapping("/{matchId}")
//    Match updateMatch(@PathVariable UUID matchId, @RequestBody Match match) throws MatchNotFoundException;
}

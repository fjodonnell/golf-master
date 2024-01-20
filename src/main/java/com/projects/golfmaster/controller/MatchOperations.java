package com.projects.golfmaster.controller;

import com.projects.golfmaster.exception.NotFoundException;
import com.projects.golfmaster.model.Match;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/match")
public interface MatchOperations {

    @GetMapping("/")
    List<Match> getAllMatches();

    @GetMapping("/matchId/{matchId}")
    Match getMatchById(@PathVariable UUID matchId) throws NotFoundException;

    @GetMapping("/teamWinner/{teamName}")
    List<Match> getMatchesWonByTeam(@PathVariable String teamName) throws NotFoundException;

    @PostMapping("/create")
    Match createMatch(@RequestBody Match match);

//    @PutMapping("/{matchId}")
//    Match updateMatch(@PathVariable UUID matchId, @RequestBody Match match) throws NotFoundException;
}

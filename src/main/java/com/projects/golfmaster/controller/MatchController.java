package com.projects.golfmaster.controller;

import com.projects.golfmaster.exception.NotFoundException;
import com.projects.golfmaster.model.Match;
import com.projects.golfmaster.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class MatchController implements MatchOperations{

    @Autowired
    MatchService matchService;

    @Override
    public List<Match> getAllMatches() {
        return matchService.getAllMatches();
    }

    @Override
    public Match getMatchById(UUID matchId) throws NotFoundException {
        return matchService.getMatchById(matchId);
    }

    @Override
    public List<Match> getMatchesWonByTeam(String teamName) throws NotFoundException {
        return matchService.getMatchesWonByTeam(teamName);
    }

    @Override
    public Match createMatch(Match match) {
        return matchService.createMatch(match);
    }

    @Override
    public Match updateMatch(UUID matchId, Match match) throws NotFoundException {
        return matchService.updateMatch(matchId, match);
    }
}

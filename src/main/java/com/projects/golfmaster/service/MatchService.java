package com.projects.golfmaster.service;

import com.projects.golfmaster.exception.NotFoundException;
import com.projects.golfmaster.model.Match;
import com.projects.golfmaster.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MatchService {

    @Autowired
    MatchRepository matchRepository;

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    public Match getMatchById(UUID matchId) throws NotFoundException {
        Optional<Match> retrievedMatch = matchRepository.findById(matchId);
        return retrievedMatch.orElseThrow(() -> new NotFoundException("Match not Found"));
    }

    public List<Match> getMatchesWonByTeam(String teamName) throws NotFoundException {
        Optional<List<Match>> retrievedMatches = matchRepository.findByTeamWinner_TeamName(teamName);
        return retrievedMatches.orElseThrow(() -> new NotFoundException("Your team has not won any matches"));
    }

    public Match createMatch(Match match) {
        return matchRepository.save(match);
    }

    public Match updateMatch(UUID matchId, Match match) throws NotFoundException {
        Optional<Match> retrievedMatch = matchRepository.findById(matchId);
        if (retrievedMatch.isPresent()) {
            Match existingMatch = retrievedMatch.get();
            existingMatch.setMatchName(match.getMatchName());
            existingMatch.setRound(match.getRound());
            existingMatch.setTeams(match.getTeams());
            existingMatch.setPlayers(match.getPlayers());
            existingMatch.setTeamWinner(match.getTeamWinner());
            existingMatch.setTeamLoser(match.getTeamLoser());
            existingMatch.setPlayerWinner(match.getPlayerWinner());
            existingMatch.setPlayerLoser(match.getPlayerLoser());
            existingMatch.setHolesWonBy(match.getHolesWonBy());
            existingMatch.setHolesRemaining(match.getHolesRemaining());
            return matchRepository.save(existingMatch);
        } else {
            throw new NotFoundException("The match you are trying to update does not exist");
        }
    }
}

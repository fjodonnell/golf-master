package com.projects.golfmaster.service;

import com.projects.golfmaster.exception.NotFoundException;
import com.projects.golfmaster.model.Team;
import com.projects.golfmaster.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    TeamRepository teamRepository;

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team getTeamByName(String teamName) throws NotFoundException {
        Optional<Team> retrievedTeam = teamRepository.findById(teamName);
        return retrievedTeam.orElseThrow(() -> new NotFoundException("Team not Found"));
    }

    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    public Team updateTeam(String teamName, Team team) throws NotFoundException {
        Optional<Team> retrievedTeam = teamRepository.findById(teamName);
        if (retrievedTeam.isPresent()) {
            Team existingTeam = retrievedTeam.get();
            existingTeam.setTeamName(team.getTeamName());
            existingTeam.setPlayers(team.getPlayers());
            return teamRepository.save(existingTeam);
        } else {
            throw new NotFoundException("Team Not Found");
        }
    }
}

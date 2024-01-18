package com.projects.golfmaster.controller;

import com.projects.golfmaster.exception.NotFoundException;
import com.projects.golfmaster.model.Team;
import com.projects.golfmaster.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class TeamController implements TeamOperations{

    @Autowired
    TeamService teamService;

    @Override
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @Override
    public Team getTeamByName(String teamName) throws NotFoundException {
        return teamService.getTeamByName(teamName);
    }

    @Override
    public Team createTeam(Team team) {
        return teamService.createTeam(team);
    }

    @Override
    public Team updateTeam(String teamName, Team team) throws NotFoundException {
        return teamService.updateTeam(teamName, team);
    }
}

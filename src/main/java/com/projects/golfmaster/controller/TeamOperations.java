package com.projects.golfmaster.controller;

import com.projects.golfmaster.exception.NotFoundException;
import com.projects.golfmaster.model.Team;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/team")
public interface TeamOperations {

    @GetMapping("/")
    List<Team> getAllTeams();

    @GetMapping("/{teamName}")
    Team getTeamByName(@PathVariable String teamName) throws NotFoundException;

    @PostMapping("/create")
    Team createTeam(@RequestBody Team team);

    @PutMapping("/{teamName}")
    Team updateTeam(@PathVariable String teamName, @RequestBody Team team) throws NotFoundException;
}

package com.projects.golfmaster.controller;

import com.projects.golfmaster.exception.NotFoundException;
import com.projects.golfmaster.model.Player;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/player")
public interface PlayerOperations {

    @GetMapping("/")
    List<Player> getAllPlayers();

    @GetMapping("/{playerId}")
    Player getPlayerById(@PathVariable String playerId) throws NotFoundException;

    @PostMapping("/create")
    Player createPlayer(@RequestBody Player player);

    @PutMapping("/{playerId}")
    Player updatePlayer(@PathVariable String playerId, @RequestBody Player updatedPlayer) throws NotFoundException;
}

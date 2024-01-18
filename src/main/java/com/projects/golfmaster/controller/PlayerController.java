package com.projects.golfmaster.controller;

import com.projects.golfmaster.exception.NotFoundException;
import com.projects.golfmaster.model.Player;
import com.projects.golfmaster.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerController implements PlayerOperations{

    @Autowired
    PlayerService playerService;

    @Override
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @Override
    public Player getPlayerById(String playerId) throws NotFoundException {
        return playerService.getPlayerById(playerId);
    }

    @Override
    public Player createPlayer(Player player) {
        return playerService.createPlayer(player);
    }

    @Override
    public Player updatePlayer(String playerId, Player updatedPlayer) throws NotFoundException {
        return playerService.updatePlayer(playerId, updatedPlayer);
    }
}

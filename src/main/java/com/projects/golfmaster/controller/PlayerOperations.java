package com.projects.golfmaster.controller;

import com.projects.golfmaster.dto.PlayerSummaryDTO;
import com.projects.golfmaster.exception.NotFoundException;
import com.projects.golfmaster.model.Player;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = {"http://localhost:3000", "https://fjodonnell.github.io/golf-master-react-ui"})
@RequestMapping("/player")
public interface PlayerOperations {
    @GetMapping("/")
    List<PlayerSummaryDTO> getAllPlayers();
    @GetMapping("/{playerId}")
    PlayerSummaryDTO getPlayerById(@PathVariable String playerId) throws NotFoundException;

    @PostMapping("/create")
    Player createPlayer(@RequestBody Player player);

    @PutMapping("/{playerId}")
    Player updatePlayer(@PathVariable String playerId, @RequestBody Player updatedPlayer) throws NotFoundException;
}

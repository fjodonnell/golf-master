package com.projects.golfmaster.service;

import com.projects.golfmaster.exception.NotFoundException;
import com.projects.golfmaster.model.Player;
import com.projects.golfmaster.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayerById(String playerId) throws NotFoundException {
        Optional<Player> retrievedPlayer = playerRepository.findById(playerId);
        return retrievedPlayer.orElseThrow(() -> new NotFoundException("Player not Found"));
    }

    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player updatePlayer(String playerId, Player updatedPlayer) throws NotFoundException {
        Optional<Player> potentialPlayer = playerRepository.findById(playerId);
        if (potentialPlayer.isPresent()){
            Player existingPlayer = potentialPlayer.get();
            existingPlayer.setPlayerId(updatedPlayer.getPlayerId());
            existingPlayer.setPlayerFirstName(updatedPlayer.getPlayerFirstName());
            existingPlayer.setPlayerLastName(updatedPlayer.getPlayerLastName());
            existingPlayer.setPlayerNickname(updatedPlayer.getPlayerNickname());
            existingPlayer.setPlayerAge(updatedPlayer.getPlayerAge());
            existingPlayer.setPlayerCity(updatedPlayer.getPlayerCity());
            existingPlayer.setPlayerState(updatedPlayer.getPlayerState());
            existingPlayer.setPlayerHandicap(updatedPlayer.getPlayerHandicap());
            existingPlayer.setPasswordHash(updatedPlayer.getPasswordHash());
            existingPlayer.setRole(updatedPlayer.getRole());
            return playerRepository.save(existingPlayer);
        } else {
            throw new NotFoundException("Player not Found");
        }
    }
}

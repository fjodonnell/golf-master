package com.projects.golfmaster.service;

import com.projects.golfmaster.dto.PlayerSummaryDTO;
import com.projects.golfmaster.exception.NotFoundException;
import com.projects.golfmaster.model.Player;
import com.projects.golfmaster.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@CacheConfig(cacheNames = "players")
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Cacheable
    public List<PlayerSummaryDTO> getAllPlayers() {
        return playerRepository.getAllPlayerSummaries();
    }

    public PlayerSummaryDTO getPlayerById(String playerId) throws NotFoundException {
        Optional<PlayerSummaryDTO> retrievedPlayer = playerRepository.getPlayerSummaryById(playerId);
        return retrievedPlayer.orElseThrow(() -> new NotFoundException("Player not Found"));
    }

    @CacheEvict(allEntries = true)
    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    @CacheEvict(allEntries = true)
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
            return playerRepository.save(existingPlayer);
        } else {
            throw new NotFoundException("Player not Found");
        }
    }
}

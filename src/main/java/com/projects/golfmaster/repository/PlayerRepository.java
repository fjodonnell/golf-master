package com.projects.golfmaster.repository;

import com.projects.golfmaster.dto.PlayerSummaryDTO;
import com.projects.golfmaster.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, String>{

    @Query("""
    SELECT new com.projects.golfmaster.dto.PlayerSummaryDTO(
        p.playerId,
        p.playerFirstName,
        p.playerLastName,
        p.playerNickname,
        p.playerCity,
        p.playerState,
        p.playerAge,
        p.playerHandicap
    )
    FROM Player p
""")
    List<PlayerSummaryDTO> getAllPlayerSummaries();

    @Query("""
    SELECT new com.projects.golfmaster.dto.PlayerSummaryDTO(
        p.playerId,
        p.playerFirstName,
        p.playerLastName,
        p.playerNickname,
        p.playerCity,
        p.playerState,
        p.playerAge,
        p.playerHandicap
        )
        FROM Player p
        WHERE p.playerId = :playerId
    """)
    Optional<PlayerSummaryDTO> getPlayerSummaryById(@Param("playerId") String playerId);

}

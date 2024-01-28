package com.projects.golfmaster.repository;

import com.projects.golfmaster.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ScoreRepository extends JpaRepository<Score, UUID> {

    Optional<List<Score>> findByPlayer_PlayerId(String playerId);

    Optional<List<Score>> findByRound_RoundId(UUID roundId);

    Optional<List<Score>> findByMatch_MatchId(UUID matchId);
}

package com.projects.golfmaster.repository;

import com.projects.golfmaster.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MatchRepository extends JpaRepository<Match, UUID> {

//    Optional<List<Match>> findByMatchTeamWinner(String teamName);
}

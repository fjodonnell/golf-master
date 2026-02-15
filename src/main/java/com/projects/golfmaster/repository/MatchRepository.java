package com.projects.golfmaster.repository;

import com.projects.golfmaster.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface MatchRepository extends JpaRepository<Match, UUID> {

    List<Match> findByTeamWinner_TeamName(String teamName);

    List<Match> findByRound_Event_EventName(String eventName);

    @Query("""
    SELECT DISTINCT m FROM matches m
    JOIN FETCH m.round r
    JOIN FETCH r.event e
    LEFT JOIN FETCH m.teamWinner tw
    LEFT JOIN FETCH m.teamLoser tl
    LEFT JOIN FETCH m.playerWinner pw
    LEFT JOIN FETCH m.playerLoser pl
    WHERE e.eventName = :eventName
""")
    List<Match> findAllByEventName(@Param("eventName") String eventName);




}

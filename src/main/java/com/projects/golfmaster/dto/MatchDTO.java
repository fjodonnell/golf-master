package com.projects.golfmaster.dto;

import java.util.List;
import java.util.UUID;

public record MatchDTO(
        UUID matchId,
        String matchName,
        Integer matchNumber,
        RoundDTO roundDTO,
        List<TeamSummaryDTO> teams,
        List<PlayerSummaryDTO> players,
        String teamWinner,
        String teamLoser,
        String playerWinner,
        String playerLoser,
        Integer holesWonBy,
        Integer holesRemaining

)
{}

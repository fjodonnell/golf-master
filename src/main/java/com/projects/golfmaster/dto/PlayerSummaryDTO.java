package com.projects.golfmaster.dto;

public record PlayerSummaryDTO(
        String playerId,
        String playerFirstName,
        String playerLastName,
        String playerNickname,
        String playerCity,
        String playerState,
        Integer playerAge,
        Integer playerHandicap
) {}

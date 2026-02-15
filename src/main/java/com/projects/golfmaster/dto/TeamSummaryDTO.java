package com.projects.golfmaster.dto;

import java.util.List;

public record TeamSummaryDTO(
        String teamName,
        List<PlayerSummaryDTO> players
) {
}

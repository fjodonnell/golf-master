package com.projects.golfmaster.dto;

import java.util.UUID;

public record RoundDTO(
        UUID roundId,
        String roundName,
        Integer roundNumber,
        EventDTO event,
        CourseDTO course
) {
}

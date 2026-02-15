package com.projects.golfmaster.dto;

import java.time.LocalDate;

public record EventDTO(
        String eventName,
        String eventLocation,
        LocalDate eventStartDate,
        LocalDate eventEndDate
) {
}

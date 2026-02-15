package com.projects.golfmaster.dto;

public record CourseDTO(
        String courseName,
        String courseCity,
        String courseState,
        Integer coursePar,
        Integer courseLength
) {
}

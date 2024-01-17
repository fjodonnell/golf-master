package com.projects.golfmaster.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = PlayerNotFoundException.class)
    public String handlePlayerNotFoundException (PlayerNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(value = EventNotFoundException.class)
    public String handleEventNotFoundException (EventNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(value = MatchNotFoundException.class)
    public String handleMatchNotFoundException (MatchNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(value = CourseNotFoundException.class)
    public String handleCourseNotFoundException (CourseNotFoundException ex) {
        return ex.getMessage();
    }


}

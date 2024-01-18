package com.projects.golfmaster.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = NotFoundException.class)
    public String handleNotFoundException (NotFoundException ex) {
        return ex.getMessage();
    }

}

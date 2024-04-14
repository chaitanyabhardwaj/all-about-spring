package com.example.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<String> handleAnimalNotFoundException(AnimalNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage() + " --- Global Handler", HttpStatus.NOT_FOUND);
    }

}

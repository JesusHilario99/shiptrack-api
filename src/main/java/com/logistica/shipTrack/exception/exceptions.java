package com.logistica.shipTrack.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class exceptions {
    
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> invalidArgument(IllegalArgumentException ex){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Error: "+ ex.getMessage());
        
    }
    
    @ExceptionHandler(TrackNumberNotFoundException.class)
    public ResponseEntity<String> trackNumberNotFound(TrackNumberNotFoundException ex){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Error: "+ ex.getMessage());
    }
    
}

package com.workintech.fswebs18challengemaven.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CardErrorResponse> handleException(CardException exception){
        CardErrorResponse response=new CardErrorResponse(exception.getMessage());
        return new ResponseEntity<>(response,exception.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<CardErrorResponse> handleException(Exception exception){
        CardErrorResponse response=new CardErrorResponse(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

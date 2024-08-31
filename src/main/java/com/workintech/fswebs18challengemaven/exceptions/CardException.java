package com.workintech.fswebs18challengemaven.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class CardException extends RuntimeException{
    private HttpStatus httpStatus;

    public CardException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}

package com.banking.bankingapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class InsufficientResources extends RuntimeException{
    public InsufficientResources(String message){
        super(message);
    }
}

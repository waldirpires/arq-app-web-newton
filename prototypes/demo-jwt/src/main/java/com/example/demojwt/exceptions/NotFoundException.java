package com.example.demojwt.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{

    public NotFoundException(String name, Integer id) {
        super("404: "+name+ " with ID " + id + " not found.");
    }
}

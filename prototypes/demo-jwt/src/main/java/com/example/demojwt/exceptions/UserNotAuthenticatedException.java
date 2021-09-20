package com.example.demojwt.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class UserNotAuthenticatedException extends RuntimeException {

    public UserNotAuthenticatedException(String userName) {
        super("User " + userName + " cannot be authenticated.");
    }
}

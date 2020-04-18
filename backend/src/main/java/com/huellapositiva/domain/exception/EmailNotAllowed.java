package com.huellapositiva.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmailNotAllowed extends RuntimeException {
    public EmailNotAllowed(String message) {
        super(message);
    }
}

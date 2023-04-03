package com.example.discountservice.exception;

import org.springframework.http.HttpStatus;

public class BaseNotFoundException extends RuntimeException implements BaseException {

    protected BaseNotFoundException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }
}

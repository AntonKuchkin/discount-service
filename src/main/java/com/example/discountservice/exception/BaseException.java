package com.example.discountservice.exception;

import org.springframework.http.HttpStatus;

public interface BaseException {
    HttpStatus getStatus();
}

package com.wilfred.citizenserver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ProblemDetail onRuntimeExceptionHandler(RuntimeException exception) {
        var problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, exception.getMessage());
        problemDetail.setTitle("Exception Message");
        problemDetail.setType(URI.create("POST/GET"));
        problemDetail.setDetail(exception.getLocalizedMessage());
        return problemDetail;
    }
}

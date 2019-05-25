package com.adrianaden.springboot.starter.exception;

import com.adrianaden.springboot.starter.dto.FailureResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class HandlerException {

    @ExceptionHandler(Exception.class)
    ResponseEntity<FailureResponse> exceptionHandler(Exception e) {
        return ResponseEntity.badRequest()
                .body(FailureResponse.builder()
                        .status(HttpStatus.BAD_REQUEST.value())
                        .message(e.getClass().getSimpleName() + ".class Unexpected Error")
                        .errors(new String[]{e.getMessage()})
                        .build()
                );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<FailureResponse> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        String[] errors = e.getBindingResult().getFieldErrors().stream()
                           .map(f -> f.getField() + " " + f.getDefaultMessage())
                           .toArray(String[]::new);

        return ResponseEntity.badRequest()
                .body(FailureResponse.builder()
                        .status(HttpStatus.BAD_REQUEST.value())
                        .message("Arguments not valid")
                        .errors(errors)
                        .build()
                );
    }
}

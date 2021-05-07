package com.adrianaden.springboot.starter.exception;

import com.adrianaden.springboot.starter.dto.FailureResponseDto;
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
    ResponseEntity<FailureResponseDto> exceptionHandler(Exception e) {
        log.error(e.getMessage(), e);

        return ResponseEntity.badRequest()
                .body(FailureResponseDto.builder()
                        .status(HttpStatus.BAD_REQUEST.value())
                        .message(e.getClass().getSimpleName() + ".class Unexpected Error")
                        .errors(new String[]{e.getMessage()})
                        .build()
                );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<FailureResponseDto> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);

        String[] errors = e.getBindingResult().getFieldErrors().stream()
                .map(f -> f.getField() + " " + f.getDefaultMessage())
                .toArray(String[]::new);

        return ResponseEntity.badRequest()
                .body(FailureResponseDto.builder()
                        .status(HttpStatus.BAD_REQUEST.value())
                        .timestamp(System.currentTimeMillis())
                        .message("Arguments not valid")
                        .errors(errors)
                        .build()
                );
    }
}

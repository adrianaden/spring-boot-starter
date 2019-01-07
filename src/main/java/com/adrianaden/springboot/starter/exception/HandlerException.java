package com.adrianaden.springboot.starter.exception;

import com.adrianaden.springboot.starter.dto.FailureResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@ControllerAdvice
public class HandlerException {

    @ExceptionHandler(Exception.class)
    ResponseEntity<FailureResponse> exceptionHandler(Exception e) {
        log.error("Unhandled Exception -> ", e);
        String message = e.getClass().getSimpleName() + ".class Unexpected Error";
        String[] errors = new String[]{e.getMessage()};

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(FailureResponse.body(message, errors));
    }


    @ExceptionHandler(NoObjectFoundException.class)
    ResponseEntity<FailureResponse> noObjectFoundExceptionHandler(NoObjectFoundException e) {
        String message = e.getClass().getSimpleName() + ".class " + e.getMessage();
        String[] errors = new String[]{e.getMessage()};

        return ResponseEntity.status(NoObjectFoundException.STATUS_CODE).body(FailureResponse.body(message, errors));
    }

    @ExceptionHandler(NoSuchElementException.class)
    ResponseEntity<FailureResponse> noSuchElementExceptionHandler(NoSuchElementException e) {
        String message = e.getClass().getSimpleName() + ".class " + e.getMessage();
        String[] errors = new String[]{e.getMessage()};

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(FailureResponse.body(message, errors));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<FailureResponse> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        String message = "arguments not valid";
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        String[] errors = new String[fieldErrors.size()];
        for (int i = 0; i < fieldErrors.size(); i++) {
            FieldError fieldError = fieldErrors.get(i);
            errors[i] = fieldError.getField() + " " + fieldError.getDefaultMessage();
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(FailureResponse.body(message, errors));
    }
}

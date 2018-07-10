package com.adrianaden.springboot.starter.dto;


import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class FailureResponse extends Response {
    private String[] errors;

    public FailureResponse(Integer status, Long timeStamp, String message, String[] errors) {
        this.status = status;
        this.timeStamp = timeStamp;
        this.message = message;
        this.errors = errors;
    }

    public static FailureResponse body(String message, String[] errors) {
        return body(HttpStatus.BAD_REQUEST.value(), System.currentTimeMillis(), message, errors);
    }

    public static FailureResponse body(Integer status, Long timeStamp, String message, String[] errors) {
        return new FailureResponse(status, timeStamp, message, errors);
    }
}

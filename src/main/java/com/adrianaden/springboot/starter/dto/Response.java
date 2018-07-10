package com.adrianaden.springboot.starter.dto;

import lombok.Data;

@Data
public class Response {

    protected Integer status;
    protected Long timeStamp;
    protected String message;

    public Response() {

    }
}

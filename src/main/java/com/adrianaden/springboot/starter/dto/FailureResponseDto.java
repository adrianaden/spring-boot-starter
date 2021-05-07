package com.adrianaden.springboot.starter.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Builder
public class FailureResponseDto {

    private Integer status;
    private Long timeStamp;
    private String message;
    private String[] errors;
}

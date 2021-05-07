package com.adrianaden.springboot.starter.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Builder
public class FailureResponseDto {

    private Integer status;
    private Long timestamp;
    private String message;
    private String[] errors;
}

package com.adrianaden.springboot.starter.dto;

import com.adrianaden.springboot.starter.annotation.Dto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@Dto
public class PersonDto {

    @NotNull
    private String firstName;

    @NotNull
    @Size(min = 5)
    private String lastName;
}

package com.adrianaden.springboot.starter.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
public class PersonDto {

    @NotNull
    private String firstName;

    @NotNull
    @Size(min = 5)
    private String lastName;
}

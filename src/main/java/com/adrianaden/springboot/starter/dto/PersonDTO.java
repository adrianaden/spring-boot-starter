package com.adrianaden.springboot.starter.dto;

import com.adrianaden.springboot.starter.common.bind.DTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@DTO
public class PersonDTO {
    @NotNull
    private String firstName;

    @NotNull
    @Size(min = 5)
    private String lastName;
}

package com.example.demo.service.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserDto {

    @NotBlank(message = "El campo nombre no puede estar vacio")
    private String Name;

    @NotBlank(message = "el campo apellido no puede estar vacio")
    private String lastName;

}

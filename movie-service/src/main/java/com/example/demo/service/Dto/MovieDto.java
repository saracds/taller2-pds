package com.example.demo.service.Dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class MovieDto {

    @NotBlank(message = "El campo titulo no puede estar vacio")
    private String Title;

    @NotBlank(message = "el campo del diretor no puede estar vacio")
    private String Diretor;

    @Size(min = 1, max = 5, message = "El rating no debe estar entre 1 y 5")
    private int Rating;
}

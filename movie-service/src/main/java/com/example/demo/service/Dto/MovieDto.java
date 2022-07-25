package com.example.demo.service.Dto;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;


@Data
public class MovieDto {

    @NotBlank(message = "El campo titulo no puede estar vacio")
    private String Title;

    @NotBlank(message = "el campo del diretor no puede estar vacio")
    private String Diretor;

    @Range(min = 1, max = 5, message = "El rating no debe estar entre 1 y 5")
    private int Rating;
}

package com.example.demo.service.dto;

import com.example.demo.model.Movie;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ShowtimeDto {

    @NotBlank(message = "La fecha no puede estar vacia")
    private LocalDateTime Date;

    private List<Movie> Movies;
}

package com.example.demo.service.dto;

import com.example.demo.model.Movie;
import com.example.demo.persistence.entity.Showtime_Movie;
import lombok.Data;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ShowtimeDto {

    @Future(message = "La fecha no puede estar vacia")
    private LocalDateTime Date;

    private List<Showtime_Movie> Movies;
}

package com.example.demo.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Showtime {

    private Long id;
    private LocalDateTime date;
    private List<Movie> movies;
}

package com.example.demo.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Showtime {

    private Long Id;
    private LocalDateTime date;
    private List<Showtime_Movie> movies;
}

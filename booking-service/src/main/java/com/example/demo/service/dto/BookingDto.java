package com.example.demo.service.dto;

import com.example.demo.model.Movie;
import lombok.Data;

import java.util.List;

@Data
public class BookingDto {

    private Long userId;
    private Long showtimeId;
    private List<Movie> movies;
}

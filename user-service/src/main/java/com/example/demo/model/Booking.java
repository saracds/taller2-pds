package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
public class Booking {

    private long Id;

    private long userId;

    private long showtimeId;

    private List<Booking_Movie> movies;

}

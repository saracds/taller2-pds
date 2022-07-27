package com.example.demo.model;

import com.example.demo.persistence.entity.Movie;
import lombok.Data;

@Data
public class Booking_Movie {

    private long Id_Booking_Movie;

    private long Id_Movie;

    private Movie movie;

}

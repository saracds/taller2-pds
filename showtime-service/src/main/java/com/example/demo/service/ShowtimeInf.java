package com.example.demo.service;

import com.example.demo.persistence.entity.Showtime;
import com.example.demo.persistence.entity.Showtime_Movie;
import com.example.demo.service.dto.ShowtimeDto;

import java.util.List;
import java.util.Optional;

public interface ShowtimeInf {

    List<Showtime> findAll();

    void save (ShowtimeDto showtimeDto);

    void update (Optional<Showtime> showtime);

    Optional<Showtime> findById(long Id);

    boolean findByMovieId (long Id);
}

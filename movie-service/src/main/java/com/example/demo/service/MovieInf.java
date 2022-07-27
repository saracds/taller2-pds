package com.example.demo.service;

import com.example.demo.persistence.entity.Movie;
import com.example.demo.service.Dto.MovieDto;

import java.util.List;
import java.util.Optional;

public interface MovieInf {

    void save (MovieDto movieDto);

    void deleteById (long Id);

    List<Movie> findAll();

    Optional<Movie> findById(long Id);

    boolean ValidateMovie (long Id);

}

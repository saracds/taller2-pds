package com.example.demo.service;

import com.example.demo.persistence.entity.Movie;
import com.example.demo.service.Dto.MovieDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService implements MovieInf{
    @Override
    public void save(MovieDto movieDto) {

    }

    @Override
    public void deleteById(long Id) {

    }

    @Override
    public List<Movie> findAll() {
        return null;
    }

    @Override
    public Optional<Movie> findById(long Id) {
        return Optional.empty();
    }
}

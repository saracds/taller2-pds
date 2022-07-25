package com.example.demo.service;

import com.example.demo.mapper.MovieMapper;
import com.example.demo.persistence.entity.Movie;
import com.example.demo.persistence.repository.MovieRepository;
import com.example.demo.service.Dto.MovieDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService implements MovieInf {

    private final MovieRepository repository;
    private final MovieMapper mapper;

    @Override
    public void save(MovieDto movieDto) {
        Movie movie = mapper.map(movieDto);
        repository.save(movie);
    }

    @Override
    public void deleteById(long Id) {
        repository.deleteById(Id);
    }

    @Override
    public List<Movie> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Movie> findById(long Id) {

        return repository.findById(Id);
    }
}

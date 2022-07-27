package com.example.demo;

import com.example.demo.persistence.entity.Movie;
import com.example.demo.persistence.repository.MovieRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class MovieRepositoryTest {

    @Autowired
    private MovieRepository repository;
    @Test
    public void executing_findById(){

        Movie movie = Movie.builder()
                .Id(1L)
                .Rating(2)
                .Title("PELICULA 1")
                .Director("DIRECTOR 1")
                .build();
        repository.save(movie);

        Optional<Movie> movie1 = repository.findById(1L);

        Assertions.assertThat(movie1.get().getId()).isEqualTo(1L);

    }


}

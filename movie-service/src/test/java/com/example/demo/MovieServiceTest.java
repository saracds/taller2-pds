package com.example.demo;

import com.example.demo.clientFeign.BookingClient;
import com.example.demo.clientFeign.ShowtimeClient;
import com.example.demo.mapper.MovieMapper;
import com.example.demo.persistence.entity.Movie;
import com.example.demo.persistence.repository.MovieRepository;
import com.example.demo.service.MovieInf;
import com.example.demo.service.MovieService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class MovieServiceTest {

    @Mock
    private MovieRepository repository;

    private MovieInf service;

    private MovieMapper mapper;

    private BookingClient bookingClient;

    private ShowtimeClient showtimeClient;

    @BeforeEach
    public void Begin(){
        MockitoAnnotations.openMocks(this);

        service = new MovieService(repository, mapper,bookingClient,showtimeClient);

        Movie movie = Movie.builder()
                .Id(1L)
                .Rating(2)
                .Title("PELICULA 1")
                .Director("DIRECTOR 1")
                .build();

        Mockito.when(repository.findById(1L))
                .thenReturn(Optional.of(movie));
    }

    @Test
    public void executing_findById(){
        Optional<Movie> movie = service.findById(1L);

        Assertions.assertThat(movie.get().getId()).isEqualTo(1L);

    }
}

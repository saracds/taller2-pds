package com.example.demo.mapper;

import co.com.responselibrary.library_response.IMapper;
import com.example.demo.persistence.entity.Movie;
import com.example.demo.service.Dto.MovieDto;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper implements IMapper<MovieDto, Movie> {
    @Override
    public Movie map(MovieDto movieDto) {
        Movie movie = new Movie();

        movie.setTitle(movieDto.getTitle());
        movie.setDirector((movieDto.getDiretor()));
        movie.setRating(movieDto.getRating());

        return movie;
    }
}

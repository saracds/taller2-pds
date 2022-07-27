package com.example.demo.service;

import com.example.demo.clientFeign.MovieClient;
import com.example.demo.mapper.ShowtimeMapper;
import com.example.demo.model.Movie;
import com.example.demo.persistence.entity.Showtime;
import com.example.demo.persistence.entity.Showtime_Movie;
import com.example.demo.persistence.repository.ShowtimeRepository;
import com.example.demo.service.dto.ShowtimeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShowtimeService implements ShowtimeInf {

    private final ShowtimeRepository repository;
    private final ShowtimeMapper mapper;
    private final MovieClient client;

    @Override
    public List<Showtime> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(ShowtimeDto showtimeDto) {

        Showtime showtime = mapper.map(showtimeDto);
        repository.save(showtime);
    }

    @Override
    public Optional<Showtime> findById(long Id) {

        Optional<Showtime> showtime = repository.findById(Id);

        if (showtime.isPresent()) {
            ModelMapper modelMapper = new ModelMapper();

            List<Showtime_Movie> items = (List<Showtime_Movie>) showtime.get().getMovies().stream()
                    .map(item -> {
                        Movie movie = modelMapper.map(client.findById(item.getId_Movie()).getData(), Movie.class);
                        item.setMovie(movie);
                        return item;
                    }).collect(Collectors.toList());
            showtime.get().setMovies(items);
            return showtime;
        } else {
            return Optional.empty();
        }
    }

    @Override
    public boolean findByMovieId(long Id) {
        List<Showtime> showtimes = repository.findAll();
        boolean encontrado = false;

        if (showtimes.size() > 0) {
            encontrado = showtimes.stream().filter((item) -> {
                return item.getMovies().stream().filter(mov -> mov.getId_Movie() == Id).findFirst().isPresent();
            }).findFirst().isPresent();

        }
        return encontrado;
    }


}

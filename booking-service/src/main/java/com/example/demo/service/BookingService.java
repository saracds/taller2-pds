package com.example.demo.service;

import com.example.demo.clienteFeign.MovieClient;
import com.example.demo.clienteFeign.ShowtimeClient;
import com.example.demo.clienteFeign.UserClient;
import com.example.demo.mapper.BookingMapper;
import com.example.demo.model.Movie;
import com.example.demo.model.Showtime;
import com.example.demo.model.User;
import com.example.demo.persistence.entity.Booking;
import com.example.demo.persistence.entity.Booking_Movie;
import com.example.demo.persistence.repository.BookingRepository;
import com.example.demo.service.dto.BookingDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingService implements BookingInf {

    private final BookingRepository repository;
    private final BookingMapper mapper;
    private final UserClient userClient;

    private final ShowtimeClient showtimeClient;

    private final MovieClient movieClient;

    @Override
    public List<Booking> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(BookingDto bookingDto) {

        Booking booking = mapper.map(bookingDto);
        repository.save(booking);
    }

    @Override
    public Optional<Booking> findById(long Id) {

        Optional<Booking> booking = repository.findById(Id);

        if(booking.isPresent()){
            ModelMapper modelMapper = new ModelMapper();

            User user = modelMapper.map(userClient.findById(booking.get().getUserId()).getData(),User.class);
            booking.get().setUser(user);

            Showtime showtime = modelMapper.map(showtimeClient.findById(booking.get().getShowtimeId()).getData(),Showtime.class);
            booking.get().setShowtime(showtime);

            List<Booking_Movie> items = (List<Booking_Movie>) booking.get().getMovies().stream()
                    .map(item -> {
                        Movie movie = modelMapper.map(movieClient.findById(item.getId_Movie()).getData(), Movie.class);
                        item.setMovie(movie);
                        return item;
                    }).collect(Collectors.toList());
            booking.get().setMovies(items);

            return booking;
        }else{
            return Optional.empty();
        }
    }

    @Override
    public void deleteById(long Id) {
        repository.deleteById(Id);
    }

    @Override
    public Optional<Booking> findByUserId(long userId) {

        Optional<Booking> booking =  repository.findByUserId(userId);
         if(booking.isPresent()){
             ModelMapper modelMapper = new ModelMapper();

             User user = modelMapper.map(userClient.findById(booking.get().getUserId()).getData(),User.class);
             booking.get().setUser(user);

             Showtime showtime = modelMapper.map(showtimeClient.findById(booking.get().getShowtimeId()).getData(),Showtime.class);
             booking.get().setShowtime(showtime);

             List<Booking_Movie> items = (List<Booking_Movie>) booking.get().getMovies().stream()
                     .map(item -> {
                         Movie movie = modelMapper.map(movieClient.findById(item.getId_Movie()).getData(), Movie.class);
                         item.setMovie(movie);
                         return item;
                     }).collect(Collectors.toList());
             booking.get().setMovies(items);

             return booking;
         }else{
             return Optional.empty();
         }

    }

    @Override
    public boolean findByMovieId(long Id) {
        List<Booking> bookings = repository.findAll();
        boolean encontrado = false;

        if (bookings.size() > 0) {
            encontrado = bookings.stream().filter((item) -> {
                return item.getMovies().stream().filter(mov -> mov.getId_Movie() == Id).findFirst().isPresent();
            }).findFirst().isPresent();

        }
        return encontrado;
    }
}

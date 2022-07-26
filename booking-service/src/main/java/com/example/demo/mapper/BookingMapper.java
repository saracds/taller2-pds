package com.example.demo.mapper;

import co.com.responselibrary.library_response.IMapper;
import com.example.demo.persistence.entity.Booking;
import com.example.demo.service.dto.BookingDto;
import org.springframework.stereotype.Component;

@Component
public class BookingMapper implements IMapper<BookingDto, Booking> {

    @Override
    public Booking map(BookingDto bookingDto) {
        Booking booking = new Booking();

        booking.setUserId(bookingDto.getUserId());
        booking.setShowtimeId(bookingDto.getShowtimeId());
        booking.setMovies(bookingDto.getMovies());

        return booking;
    }
}

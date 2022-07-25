package com.example.demo.mapper;

import co.com.responselibrary.library_response.IMapper;
import com.example.demo.persistence.entity.Showtime;
import com.example.demo.service.dto.ShowtimeDto;
import org.springframework.stereotype.Component;

@Component
public class ShowtimeMapper implements IMapper<ShowtimeDto,Showtime> {

    @Override
    public Showtime map(ShowtimeDto showtimeDto) {

        Showtime showtime = new Showtime();

        showtime.setDate(showtimeDto.getDate());
        showtime.setMovies(showtimeDto.getMovies());

        return showtime;
    }
}

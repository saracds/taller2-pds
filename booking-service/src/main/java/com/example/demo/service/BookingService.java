package com.example.demo.service;

import com.example.demo.mapper.BookingMapper;
import com.example.demo.persistence.entity.Booking;
import com.example.demo.persistence.repository.BookingRepository;
import com.example.demo.service.dto.BookingDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingService implements BookingInf {

    private final BookingRepository repository;
    private final BookingMapper mapper;

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
        return repository.findById(Id);
    }

    @Override
    public void deleteById(long Id) {
        repository.deleteById(Id);
    }

    @Override
    public Optional<Booking> findByUserId(long userId) {
        return repository.findByUserId(userId);
    }
}

package com.example.demo.service;

import com.example.demo.persistence.entity.Booking;
import com.example.demo.service.dto.BookingDto;

import java.util.List;
import java.util.Optional;

public interface BookingInf {

    List<Booking> findAll();

    void save (BookingDto bookingDto);

    Optional<Booking> findById(long Id);

    void deleteById (long Id);

    Optional<Booking> findByUserId (long userId);
}

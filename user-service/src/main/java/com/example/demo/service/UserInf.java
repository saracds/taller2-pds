package com.example.demo.service;

import com.example.demo.model.Booking;
import com.example.demo.persistence.entity.User;
import com.example.demo.service.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserInf {

    void save (UserDto userDto);

    void deleteById (long Id);

    List<User> findAll();

    Optional<User> findById(long Id);

    Booking findBookingByUserId (long Id);
}

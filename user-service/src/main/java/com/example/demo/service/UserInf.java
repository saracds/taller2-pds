package com.example.demo.service;

import com.example.demo.persistence.entity.User;
import com.example.demo.service.dto.UserDto;

import java.util.List;

public interface UserInf {

    void save (UserDto userDto);

    void deleteById (long Id);

    List<User> findAll();
}

package com.example.demo.service;

import com.example.demo.persistence.entity.User;

import java.util.List;

public interface UserImp {

    void save (User user);

    void deleteById (long Id);

    List<User> findAll();
}

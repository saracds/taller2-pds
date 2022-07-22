package com.example.demo.service;

import com.example.demo.persistence.entity.User;
import com.example.demo.persistence.respository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserImp{

   private final UserRepository repository;

    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public void deleteById(long Id) {
        repository.deleteById(Id);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
}

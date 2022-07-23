package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.persistence.entity.User;
import com.example.demo.persistence.respository.UserRepository;
import com.example.demo.service.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserInf {

   private final UserRepository repository;
   private final UserMapper mapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(UserDto userDto) {

        User user = mapper.map(userDto);
        repository.save(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(long Id) {
        repository.deleteById(Id);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
}

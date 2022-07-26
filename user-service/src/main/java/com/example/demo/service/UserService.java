package com.example.demo.service;

import co.com.responselibrary.library_response.Response;
import com.example.demo.clientFeign.BookingClient;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.Booking;
import com.example.demo.persistence.entity.User;
import com.example.demo.persistence.respository.UserRepository;
import com.example.demo.service.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserInf {

   private final UserRepository repository;
   private final UserMapper mapper;
   private final BookingClient client;

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

    @Override
    public Optional<User> findById(long Id) {
        return repository.findById(Id);
    }

    @Override
    public Booking findBookingByUserId(long Id) {
       Response response = client.findByUserId(Id);
        ModelMapper modelMapper = new ModelMapper();

        Booking  booking = modelMapper.map((Object) response, (Type) Booking.class);

        System.out.println("---- " + booking + " -----");
       return  booking;
    }
}

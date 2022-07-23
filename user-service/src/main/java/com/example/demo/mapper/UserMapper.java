package com.example.demo.mapper;

import co.com.responselibrary.library_response.IMapper;
import com.example.demo.persistence.entity.User;
import com.example.demo.service.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements IMapper<UserDto, User> {

    @Override
    public User map(UserDto userDto) {

        User user = new User();

        user.setName(userDto.getName());
        user.setLastName(userDto.getLastName());

        return user;
    }
}

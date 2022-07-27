package com.example.demo;

import com.example.demo.clientFeign.BookingClient;
import com.example.demo.mapper.UserMapper;
import com.example.demo.persistence.entity.User;
import com.example.demo.persistence.respository.UserRepository;
import com.example.demo.service.UserInf;
import com.example.demo.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
public class UserServiceTest {

    @Mock
    private UserRepository repository;

    private UserInf service;

    private UserMapper mapper;

    private BookingClient client;

    @BeforeEach
    public void Begin(){
        MockitoAnnotations.openMocks(this);

        service = new UserService(repository, mapper,client);

        User user  = User.builder()
                .Id(1L)
                .Name("Juan")
                .lastName("Perez")
                .build();


        Mockito.when(repository.findById(1L))
                .thenReturn(Optional.of(user));
    }

    @Test
    public void executing_findById(){
        Optional<User> user = service.findById(1L);

        Assertions.assertThat(user.get().getId()).isEqualTo(1L);

    }
}

package com.example.demo;

import com.example.demo.persistence.entity.User;
import com.example.demo.persistence.respository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.Optional;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void executing_findById(){

        User user  = User.builder()
                .Id(1L)
                .Name("Juan")
                .lastName("Perez")
                .build();
        repository.save(user);

        Optional<User> user1 = repository.findById(1L);

        Assertions.assertThat(user1.get().getId()).isEqualTo(1L);

    }
}

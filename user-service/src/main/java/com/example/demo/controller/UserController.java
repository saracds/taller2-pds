package com.example.demo.controller;

import com.example.demo.persistence.entity.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping
    private List<User> findAll() {
        return service.findAll();
    }

    @PostMapping
    private void save(@Valid @RequestBody User user, BindingResult result) {
        if (!result.hasErrors()) {
            service.save(user);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") long Id) {
        service.deleteById(Id);
    }
}

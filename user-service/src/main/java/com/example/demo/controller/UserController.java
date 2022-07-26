package com.example.demo.controller;

import co.com.responselibrary.library_response.FormatMessage;
import co.com.responselibrary.library_response.Response;
import co.com.responselibrary.library_response.ResponseBuild;
import com.example.demo.service.UserService;
import com.example.demo.service.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@ComponentScan("co.com.responselibrary.*")
public class UserController {

    private final UserService service;
    private final ResponseBuild build;
    private final FormatMessage formatMessage;

    @GetMapping
    private Response findAll() {
        return  build.success(service.findAll());
    }

    @PostMapping
    private Response save(@Valid @RequestBody UserDto user, BindingResult result) {

        if (result.hasErrors()) {
            return build.failed(formatMessage.formatMessage(result));
        } else {
            service.save(user);
            return build.created(user);
        }
    }

    @DeleteMapping("/{id}")
    public Response deleteById(@PathVariable("id") long Id) {
        var booking = service.findBookingByUserId(Id);
        if(booking != null){
            return build.failed("No se puede eliminar el usuario, tiene reservas asociadas");
        }else{
            service.deleteById(Id);
            return build.success();
        }
    }
    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") long Id) {

        var user = service.findById(Id);

        if (!user.isPresent()) {
            return build.notFound("No se encontro el usuario con el id " + Id);
        }else {
            return build.success(user);
        }

    }

}

package com.example.demo.controller;

import co.com.responselibrary.library_response.FormatMessage;
import co.com.responselibrary.library_response.Response;
import co.com.responselibrary.library_response.ResponseBuild;
import com.example.demo.service.BookingService;
import com.example.demo.service.dto.BookingDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
@ComponentScan("co.com.responselibrary.*")
public class BookingController {

    private final BookingService service;
    private final ResponseBuild build;
    private final FormatMessage formatMessage;

    @GetMapping
    private Response findAll() {
        return  build.success(service.findAll());
    }

    @PostMapping
    private Response save(@Valid @RequestBody BookingDto bookingDto, BindingResult result) {

        if (result.hasErrors()) {
            return build.failed(formatMessage.formatMessage(result));
        } else {
            service.save(bookingDto);
            return build.created(bookingDto);
        }
    }
    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") long Id) {

        var booking = service.findById(Id);

        if (!booking.isPresent()) {
            return build.notFound("No se encontro la reserva con el id " + Id);
        }
        return build.success(booking);
    }

    @DeleteMapping("/{id}")
    public Response deleteById(@PathVariable("id") long Id) {
        service.deleteById(Id);
        return build.success();
    }

    @GetMapping("/{userId}")
    public Response findByUserId(@PathVariable("userId") long userId) {

        var booking = service.findByUserId(userId);

        if (!booking.isPresent()) {
            return build.notFound("No se encontro la reserva con el id de usuario" + userId);
        }
        return build.success(booking);
    }
}

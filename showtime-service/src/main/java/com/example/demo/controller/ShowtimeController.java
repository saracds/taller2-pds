package com.example.demo.controller;

import co.com.responselibrary.library_response.FormatMessage;
import co.com.responselibrary.library_response.Response;
import co.com.responselibrary.library_response.ResponseBuild;
import com.example.demo.service.ShowtimeService;
import com.example.demo.service.dto.ShowtimeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/showtimes")
@RequiredArgsConstructor
@ComponentScan("co.com.responselibrary.*")
public class ShowtimeController {

    private final ShowtimeService service;
    private final ResponseBuild build;
    private final FormatMessage formatMessage;

    @GetMapping
    private Response findAll() {

        return  build.success(service.findAll());
    }

    @PostMapping
    private Response save(@Valid @RequestBody ShowtimeDto showtimeDto, BindingResult result) {

        if (result.hasErrors()) {
            return build.failed(formatMessage.formatMessage(result));
        } else {
            service.save(showtimeDto);
            return build.created(showtimeDto);
        }
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") long Id) {

        var showtime = service.findById(Id);

        if (!showtime.isPresent()) {
            return build.notFound("No se encontro la programacion con el id " + Id);
        }
        return build.success(showtime);
    }
}

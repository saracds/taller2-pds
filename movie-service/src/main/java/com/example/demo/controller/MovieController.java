package com.example.demo.controller;

import co.com.responselibrary.library_response.FormatMessage;
import co.com.responselibrary.library_response.Response;
import co.com.responselibrary.library_response.ResponseBuild;
import com.example.demo.persistence.entity.Movie;
import com.example.demo.service.Dto.MovieDto;
import com.example.demo.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
@ComponentScan("co.com.responselibrary.*")
public class MovieController {

    private final MovieService service;
    private final ResponseBuild build;
    private final FormatMessage formatMessage;

    @GetMapping
    private Response findAll() {
        return  build.success(service.findAll());
    }

    @PostMapping
    private Response save(@Valid @RequestBody MovieDto movieDto, BindingResult result) {

        if (result.hasErrors()) {
            return build.failed(formatMessage.formatMessage(result));
        } else {
            service.save(movieDto);
            return build.created(movieDto);
        }
    }
    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") long Id) {

        var movie = service.findById(Id);

        if (!movie.isPresent()) {
            return build.notFound("No se encontro la pelicula con el id " + Id);
        }
        return build.success(movie);
    }

    @DeleteMapping("/{id}")
    public Response deleteById(@PathVariable("id") long Id) {

        Optional<Movie>movie = service.findById(Id);

        if(movie.isPresent()){
            var validation = service.ValidateMovie(Id);
            if(validation){
                service.deleteById(Id);
                return build.success();
            }else{
                return build.failed("No se puede eliminar la pelicula, ya que tiene programaciones o reservas asociadas");
            }
        }else{
            return build.notFound("No se encontro la pelicula con el id " + Id);
        }

    }
}

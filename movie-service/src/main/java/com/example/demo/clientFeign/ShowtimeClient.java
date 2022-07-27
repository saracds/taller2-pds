package com.example.demo.clientFeign;

import co.com.responselibrary.library_response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "showtime-service", fallback = ShowtimeClientImplHystrixFallBack.class)
public interface ShowtimeClient {

    @GetMapping("/taller2/api/v1/showtimes/movie/{movieId}")
    Response findByMovieId(@PathVariable("movieId") Long userId);
}

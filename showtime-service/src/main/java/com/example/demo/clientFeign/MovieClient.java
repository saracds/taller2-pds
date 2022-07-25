package com.example.demo.clientFeign;

import co.com.responselibrary.library_response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "movie-service", fallback = MovieClientImplHystrixFallBack.class)
public interface MovieClient {

    @GetMapping("/taller2/api/v1/movies/{id}")
    Response findById(@PathVariable("id") Long Id);


}

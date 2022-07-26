package com.example.demo.clienteFeign;

import co.com.responselibrary.library_response.Response;
import co.com.responselibrary.library_response.ResponseBuild;
import com.example.demo.model.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovieClientImplHystrixFallBack implements MovieClient{

    private final ResponseBuild build;


    @Override
    public Response findById(Long Id) {
        return build.success(new Movie());
    }
}

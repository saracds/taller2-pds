package com.example.demo.clienteFeign;

import co.com.responselibrary.library_response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", fallback = UserClientImplHystrixFallBack.class)
public interface UserClient {

    @GetMapping("/taller2/api/v1/users/{id}")
    Response findById(@PathVariable("id") Long Id);
}

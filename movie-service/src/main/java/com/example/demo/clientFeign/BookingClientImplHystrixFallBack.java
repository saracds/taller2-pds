package com.example.demo.clientFeign;

import co.com.responselibrary.library_response.Response;
import co.com.responselibrary.library_response.ResponseBuild;
import com.example.demo.model.Booking;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookingClientImplHystrixFallBack implements BookingClient {

    private final ResponseBuild build;


}

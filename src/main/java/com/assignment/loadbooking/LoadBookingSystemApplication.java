package com.assignment.loadbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "Load & Booking API", version = "1.0", description = "APIs for managing loads and bookings"))
@SpringBootApplication
@ComponentScan(basePackages = "com.assignment.loadbooking")
public class LoadBookingSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoadBookingSystemApplication.class, args);
    }
}
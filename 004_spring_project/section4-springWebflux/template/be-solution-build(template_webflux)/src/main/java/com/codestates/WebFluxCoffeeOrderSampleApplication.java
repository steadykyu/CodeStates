package com.codestates;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@EnableR2dbcRepositories    // (1)
@EnableR2dbcAuditing        // (2)
@SpringBootApplication
public class WebFluxCoffeeOrderSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebFluxCoffeeOrderSampleApplication.class, args);
    }

}
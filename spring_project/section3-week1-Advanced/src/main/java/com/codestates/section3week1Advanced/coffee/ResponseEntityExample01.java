package com.codestates.section3week1Advanced.coffee;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2/coffees")
public class ResponseEntityExample01 {
    @GetMapping("/{coffee-id}")
    public ResponseEntity getCoffee(@PathVariable("coffee-id") long coffeeId) {

        if (coffeeId < 0) {
            return new ResponseEntity<>(
                    "coffeeId should be greater than 0",
                    HttpStatus.BAD_REQUEST);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "bar");
        return new ResponseEntity<>(new Coffee("규하","kyuha",5555), headers, HttpStatus.OK);
    }
}


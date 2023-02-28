package com.codestates.section3week1Advanced.coffee;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v3/coffees")
public class ResponseEntityExample03 {
    @GetMapping("/{coffee-id}")
    public ResponseEntity getCoffee(@PathVariable("coffee-id") long coffeeId) {

        if (coffeeId < 0) {
            return ResponseEntity.badRequest().body("coffeeId should be greater than 0");
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "bar");
        return ResponseEntity.ok().headers(headers).body(new Coffee("규하3","kyuha",3333));
    }
}


package com.codestates.section3week1Advanced.restTemplate;

import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class RestClientExample03 {
    public static void main(String[] args) {
        // (1) 객체 생성
        RestTemplate restTemplate =
                new RestTemplate(new HttpComponentsClientHttpRequestFactory());

        // (2) URI 생성
        UriComponents uriComponents =
                UriComponentsBuilder
                        .newInstance()
                        .scheme("http")
                        .host("worldtimeapi.org")
//                        .port(80)
                        .path("/api/timezone/{continents}/{city}")
                        .encode()
                        .build();
        URI uri = uriComponents.expand("Asia", "Seoul").toUri();

        // (3) Request 전송. exchange()를 사용한 일반화 된 방식
        ResponseEntity<WorldTime> response =
                restTemplate.exchange(uri,
                HttpMethod.GET,
                null,
                WorldTime.class);

        System.out.println("# datatime: " + response.getBody().getDatetime());
        System.out.println("# timezone: " + response.getBody().getTimezone());
        System.out.println("# day_of_week: " + response.getBody().getDay_of_week());
        System.out.println("# HTTP Status Code: " + response.getStatusCode());
        System.out.println("# HTTP Status Value: " + response.getStatusCodeValue());
    }
}

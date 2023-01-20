package com.codestates.section3week1Advanced.restTemplate;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class RestClientExample01 {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());

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

        WorldTime worldTime = restTemplate.getForObject(uri, WorldTime.class);

        System.out.println("# datatime: "+ worldTime.getDatetime());
        System.out.println("# timezone: "+ worldTime.getTimezone());
        System.out.println("# day_if_week: "+ worldTime.getDay_of_week());
    }
}

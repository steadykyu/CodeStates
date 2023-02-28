package com.codestates.section3week1Advanced.coffee;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/v22/coffees")
public class ResponseEntityExample02 {
    @PostMapping
    public ResponseEntity<Coffee> postCoffee(Coffee coffee) {

        // coffee 정보 저장
        long savedCoffeeId = 1L;
        return ResponseEntity.created(URI.create("/coffees/" + savedCoffeeId)).body(coffee);
    }
}
// created() 메서드의 경우 URI를 지정할 수 있는데,
// 이는 새롭게 생성된 리소스에 대한 접근 URI를
// Location 헤더 값으로 포함시킴으로써 클라이언트 쪽에서
// 이 정보를 이용해 해당 리소스에 접근할 수 있도록 해줍니다.

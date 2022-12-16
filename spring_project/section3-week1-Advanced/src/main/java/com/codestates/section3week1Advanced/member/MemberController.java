package com.codestates.section3week1Advanced.member;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/v1/members", produces = {MediaType.APPLICATION_JSON_VALUE})
public class MemberController {
//    @PostMapping
//    public ResponseEntity postMember(@RequestParam("email") String email,
//                                     @RequestParam("name") String name,
//                                     @RequestParam("phone") String phone){
//        Map<String, String> map = new HashMap<>();
//        map.put("email", email);
//        map.put("name", name);
//        map.put("phone", phone);
//
//        return new ResponseEntity<>(map, HttpStatus.CREATED);
//    }

    // 헤더 추가
    @PostMapping
    public ResponseEntity addHeader(@RequestParam("email") String email,
                                     @RequestParam("name") String name,
                                     @RequestParam("phone") String phone) {
        // (1) 위치 정보를 헤더에 추가
        HttpHeaders headers = new HttpHeaders();
        headers.set("Client-Geo-Location", "Korea,Seoul");

        return new ResponseEntity<>(new Member(email, name, phone), headers,
                HttpStatus.CREATED);
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id")long memberId){
        System.out.println("# memberId: "+ memberId);

        // not implementation
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getMembers(){
        System.out.println("# get Members");
        // not implementation
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

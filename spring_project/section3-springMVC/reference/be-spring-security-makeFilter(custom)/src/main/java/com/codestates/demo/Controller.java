package com.codestates.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filters")
public class Controller {

    @PostMapping
    public String postMember(@RequestBody Member member){
        System.out.println("--------회원 등록 핸들러 매핑----------");
        return "회원 등록이 완료 되었습니다.";
    }

}

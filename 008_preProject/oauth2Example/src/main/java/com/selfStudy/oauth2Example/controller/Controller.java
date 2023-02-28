package com.selfStudy.oauth2Example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping
    public String helloOauth2(){
        return "helloOauth2";
    }
}

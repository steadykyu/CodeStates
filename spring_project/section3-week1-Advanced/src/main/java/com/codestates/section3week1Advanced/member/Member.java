package com.codestates.section3week1Advanced.member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    private String email;
    private String name;
    private String phone;

    public Member(String email, String name, String phone) {
        this.email = email;
        this.name = name;
        this.phone = phone;
    }
}

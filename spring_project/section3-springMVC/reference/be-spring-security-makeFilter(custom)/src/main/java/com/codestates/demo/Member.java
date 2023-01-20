package com.codestates.demo;


public class Member {

    private long memberId;
    private String name;

    public Member(long memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }
}

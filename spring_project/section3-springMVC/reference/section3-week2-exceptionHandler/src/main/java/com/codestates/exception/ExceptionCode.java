package com.codestates.exception;

import lombok.Getter;

public enum ExceptionCode {
    MEMBER_NOT_FOUND(405, "Member Not Found"),
    MEMBER_ALREADY_FOUND(500, "Member Alreay Found"),
    PASSWORD_NOT_VAILD(404, "Password is not vaild");
    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}

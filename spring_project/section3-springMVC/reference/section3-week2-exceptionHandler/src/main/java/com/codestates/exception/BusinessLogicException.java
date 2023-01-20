package com.codestates.exception;

import lombok.Getter;

public class BusinessLogicException extends RuntimeException{
    @Getter
    private ExceptionCode exceptionCode;

    public BusinessLogicException(ExceptionCode exceptionCode){
        // public RuntimeException(String message) {
        //        super(message);
        //    }
        super(exceptionCode.getMessage());
        this.exceptionCode = exceptionCode;
    }
}

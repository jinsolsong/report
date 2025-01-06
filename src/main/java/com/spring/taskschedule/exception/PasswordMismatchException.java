package com.spring.taskschedule.exception;

import lombok.Getter;

@Getter
public class PasswordMismatchException extends RuntimeException{

    //속성
    private String errorMessage;

    //생
    public PasswordMismatchException(String errorMessage){
        this.errorMessage = errorMessage;
    }
}

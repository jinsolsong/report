package com.spring.taskschedule.exception;

import lombok.Getter;

@Getter
public class IdAndPasswordMismatchException extends RuntimeException{
    //속
    private String errorMessage;

    //생
    public IdAndPasswordMismatchException(String errorMessage){
        this.errorMessage = errorMessage;
    }

}

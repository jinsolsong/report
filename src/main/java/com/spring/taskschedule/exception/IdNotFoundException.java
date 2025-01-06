package com.spring.taskschedule.exception;

import lombok.Getter;

@Getter
public class IdNotFoundException extends RuntimeException{

    //속
    private String errorMessage;

    //생
    public IdNotFoundException(String errorMessage){
        this.errorMessage = errorMessage;
    }



    //기



}

package com.spring.taskschedule.exception;

import org.springframework.http.HttpStatus;

public class ApiResponse<T> {
    //속
    private HttpStatus status; //상태코드

    private String message;//메세지




    //생
    private ApiResponse(HttpStatus status, String message){
        this.status = status;
        this.message = message;

    }


    //기

    public static <T> ApiResponse <T> success(HttpStatus status, String message){
        return new ApiResponse<>(status, message);
    }

    public static <T> ApiResponse <T> error(HttpStatus status, String message){
        return new ApiResponse<>(status, message);
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }


}

package com.spring.taskschedule.lv1.dto;

import lombok.Getter;

@Getter
public class RequestDto {

    private final String userName;

    private final String title;

    private final String todo;

    public RequestDto(String userName, String title, String todo) {
        this.userName = userName;
        this.title = title;
        this.todo = todo;
    }
}

package com.spring.taskschedule.lv1.dto;


import com.spring.taskschedule.lv1.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class ResponseDto {


    private final Long id;

    private final String userName;

    private final String title;

    private final String todo;

    private final String createdDate;



    public ResponseDto(Long id, String userName, String title, String todo, String createdDate) {
        this.id = id;
        this.userName = userName;
        this.title = title;
        this.todo = todo;
        this.createdDate = createdDate;
    }


    public static ResponseDto toDto(Schedule schedule){

        String createdDate = createdDate(schedule.getCreatedDate());

        return new ResponseDto(schedule.getId(), schedule.getUserName(), schedule.getTitle(), schedule.getTodo(), createdDate);
    }


    private static String createdDate(LocalDateTime createdDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  // 나노초 제외
        return createdDate.format(formatter);
    }

}

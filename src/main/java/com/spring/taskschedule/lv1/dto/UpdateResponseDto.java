package com.spring.taskschedule.lv1.dto;

import com.spring.taskschedule.lv1.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class UpdateResponseDto {

    private final Long id;

    private final String userName;

    private final String title;

    private final String todo;

    private final String updatedDate;




    public UpdateResponseDto(Long id, String userName, String title, String todo, String updatedDate) {
        this.id = id;
        this.userName = userName;
        this.title = title;
        this.todo = todo;
        this.updatedDate = updatedDate;
    }



    public static UpdateResponseDto updateSchedule(Schedule schedule){

        String updateSchedule= updatedDate(schedule.getUpdatedDate());

        return new UpdateResponseDto(schedule.getId(), schedule.getUserName(), schedule.getTitle(), schedule.getTodo(), updateSchedule);
    }

    private static String updatedDate(LocalDateTime updatedDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  // 나노초 제외
        return updatedDate.format(formatter);
    }

}


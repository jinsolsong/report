package com.spring.taskschedule.dto;

import com.spring.taskschedule.entity.ScheduleEntity;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class ScheduleResponseDto {

    private final Long id;

    private final String title;

    private final String todo;

    private final String createDate;

    public ScheduleResponseDto(Long id, String title, String todo, String createDate) {
        this.id = id;
        this.title = title;
        this.todo = todo;
        this.createDate = createDate;
    }

    public static ScheduleResponseDto toDto(ScheduleEntity scheduleEntity){

       String createDate = createDate(scheduleEntity.getCreatedDate());

        return new ScheduleResponseDto(
                scheduleEntity.getId(),
                scheduleEntity.getTitle(),
                scheduleEntity.getTodo(),
                createDate
        );
    }

    private static String createDate(LocalDateTime createDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return createDate.format(formatter);
    }
}

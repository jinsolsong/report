package com.spring.taskschedule.dto;

import lombok.Getter;

@Getter
public class CreateScheduleRequestDto {

    //유저의 식별자 번호만 받으면됨
    //입력받은 유저식별자 번호가 존재하는지 확인 후 예외처리
    //스케줄 생성할때 그때 데이터베이스에서 찾아온 유저를 넣어주기

    private final Long userId;

    private final String title;

    private final String todo;



    public CreateScheduleRequestDto(Long userId, String title, String todo) {
        this.userId = userId;

        this.title = title;

        this.todo = todo;
    }
}

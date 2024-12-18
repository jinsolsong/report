package com.spring.taskschedule.dto;

import lombok.Getter;

@Getter
public class UserRequestDto {

    //이름, 이메일, (lv3 비밀번호)

    private final String username;

    private final String eMail;

    private final String password;

    public UserRequestDto(String username, String eMail, String password) {
        this.username = username;
        this.eMail = eMail;
        this.password = password;
    }
}

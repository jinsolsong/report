package com.spring.taskschedule.dto;

import com.spring.taskschedule.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Getter
public class UserResponseDto {

    //ID, 유저명, 이메일, 작성일, (수정일)

    private final Long id;

    private final String username;

    private final String eMail;

    private final String createdDate;

    public UserResponseDto(Long id, String username, String eMail, String createdDate) {
        this.id = id;
        this.username = username;
        this.eMail = eMail;
        this.createdDate = createdDate;
    }



    public static UserResponseDto toDto(User user){

        String createDate = createdDate(user.getCreatedDate());

        return new UserResponseDto(
                user.getId(),
                user.getUsername(),
                user.getEMail(),
                createDate);

    }

    private static String createdDate(LocalDateTime createDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return createDate.format(formatter);
    }


}

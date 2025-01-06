package com.spring.taskschedule.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UserRequestDto {

    //이름, 이메일, (lv3 비밀번호)

    @NotBlank
    private final String username;

    @NotBlank
    @Email
    private final String eMail;

    @NotBlank
    @Size(min = 8, max = 12)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*(),.?\":{}|<>])[a-zA-Z0-9!@#$%^&*(),.?\":{}|<>]+$",
            message = "영문 대소문자, 숫자, 특수문자를 각각 최소 1글자씩 포함해야 합니다.")
    private final String password;

    public UserRequestDto(String username, String eMail, String password) {
        this.username = username;
        this.eMail = eMail;
        this.password = password;
    }
}

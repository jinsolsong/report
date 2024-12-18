package com.spring.taskschedule.controller;


import com.spring.taskschedule.dto.UserRequestDto;
import com.spring.taskschedule.dto.UserResponseDto;
import com.spring.taskschedule.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserLoginController {

    private final UserService userService;

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute
                            UserRequestDto request,
                            HttpServletResponse response
    ){
        //로그인 유저 조회
        UserResponseDto responseDto = userService.login(request.getUsername(),request.getPassword());


        if(responseDto.getId() == null){
            //로그인 실패 예외처리
            return "login";
        }

        //로그인 성공 처리
        //쿠키 생성, Value는 문자열로 변환하여야 함
        Cookie cookie = new Cookie("userId", String.valueOf(responseDto.getId()));

        //쿠키에 값 세팅(expire 시간을 주지 않으면 세션쿠키가 됨, 브라우저 종료시 로그아웃)
        //Response Set-Cookie : userId = 1 형태로 전달된다
        response.addCookie(cookie);

        //home 페이지로 리다이렉트
        return "redirect:/home";

    }

    @PostMapping("/logout")
    public String logout(
            HttpServletResponse response
    ){
        Cookie cookie = new Cookie("userId", null);

        //0초로 쿠키를 세팅하여 사라지게 만듬
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        //home페이지로 리다이렉트
        return "redirect:/home";
    }





}
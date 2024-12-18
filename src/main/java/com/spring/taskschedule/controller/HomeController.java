package com.spring.taskschedule.controller;

import com.spring.taskschedule.dto.UserResponseDto;
import com.spring.taskschedule.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final UserService userService;

    @GetMapping("/home")
    public String home(
            //@CookeValue(required = true)로 필수값(default)설정
            //required = false 이면 필수값이 아님
            @CookieValue(name = "userId", required = false) Long userId,
            Model model
    ){
        //쿠키에 값이 없으면 로그인페이지로 이동
        if (userId == null){
            return "login";
        }
        //데이터베이스에 데이터 조회 후 결과가 없으면 로그인 페이지로 이동(일치하는 값이 없으면)
        UserResponseDto loginUser = userService.findById(userId);

        if (loginUser == null){
            return "login";
        }

        //정상적으로 로그인이 된 사람이라면 뷰에서 사용할 데이터를 모델 객체에 임시저장
        model.addAttribute("loginUser", loginUser);

        return "home";
    }




}

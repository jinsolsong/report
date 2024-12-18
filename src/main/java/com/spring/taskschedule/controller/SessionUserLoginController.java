package com.spring.taskschedule.controller;

import com.spring.taskschedule.dto.UserRequestDto;
import com.spring.taskschedule.dto.UserResponseDto;
import com.spring.taskschedule.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SessionUserLoginController {

    private final UserService userService;

    @PostMapping("/session-login")
    public ResponseEntity<String> login(
            @Valid @ModelAttribute UserRequestDto dto,
            HttpServletRequest request
            ){
        UserResponseDto responseDto = userService.login(dto.getUsername(), dto.getPassword());

        Long userId = responseDto.getId();
        //실패시 예외처리
        if(userId == null){
            return new ResponseEntity<>("로그인 실패(아이디와 비밀번호를 확인하세요)", HttpStatus.UNAUTHORIZED);
        }

        // 로그인 성공시 로직
        // 세션의 Defalt Value 는 true
        // 세션이 request에 존재하면 기존의 세션을 반환하고,
        // 세션이 request에 없으면 새로 세선을 생성

        HttpSession session = request.getSession();

        //회원정보 조회
        UserResponseDto loginUser = userService.findById(userId);

        // 세션에 로그인 회원 정보를 저장
        session.setAttribute("LOGIN_USER", loginUser);

        //로그인 성공시 리다이렉트
        return new ResponseEntity<>("로그인 되었습니다. ", HttpStatus.OK);
    }

    @PostMapping("/session-logout")
    public ResponseEntity<String> logout(HttpServletRequest request){

        //로그인하지 않으면 Httpsession이 null로 반환
        //true로 설정이 된다면,
        // 리퀘스트 객체 내에 세션이 존재한다면 기존 세션을 반환
        // 리퀘스트 객체 내에 세션이 없으면 새로운 세션을 생성해서 반환
        HttpSession session = request.getSession(false);

        //세션이 존재한다면 >> 로그인이 된경우
        if(session != null){
            session.invalidate(); //해당 세션을 삭제
        }
        return new ResponseEntity<>("로그아웃 되었습니다. ", HttpStatus.OK);
    }

}

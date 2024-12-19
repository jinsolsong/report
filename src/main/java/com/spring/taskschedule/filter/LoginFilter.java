package com.spring.taskschedule.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;

@Slf4j
public class LoginFilter implements Filter {

    //인증 하지 않아도 될 URL 배열
    private static final String[] WHITE_LIST =
            {"/", "/users/signup", "/login", "/session-login","/session-logout", "/session-home"};

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain
    )throws IOException, ServletException{


            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpServletResponse httpResponse = (HttpServletResponse) response;

            String requestURI = httpRequest.getRequestURI();

            log.info("로그인 필터 로직 실행");

            if(!isWhiteList(requestURI)){
                HttpSession session = httpRequest.getSession(false);

                if(session == null || session.getAttribute("LOGIN_USER")==null){

                    httpResponse.sendRedirect("/login"); //로그인이 되지않았다는 예외처리 응답 //힌트 : 예외던지면 400안뜰거임 서버뜰거임

                    return;
                }

            }

            chain.doFilter(request,response);
        }

        private boolean isWhiteList(String requestURI){
        return PatternMatchUtils.simpleMatch(WHITE_LIST, requestURI);
        }
    }



package com.nhnacademy.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("ClientCheckInterceptor preHandle");
        HttpSession session = request.getSession();
        if (Objects.isNull(session.getAttribute("login"))) {
            response.sendRedirect("/");
            return false;
        }
        return true;
    }
}

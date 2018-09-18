package com.epam.hospital.hospital_web.web.interceptor;

import com.epam.hospital.hospital_web.web.manager.UsersManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthPersonaInterceptor extends HandlerInterceptorAdapter {

    private final UsersManager usersManager;

    @Autowired
    public AuthPersonaInterceptor(UsersManager usersManager) {
        this.usersManager = usersManager;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (usersManager.getUsers() == null) {
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
}

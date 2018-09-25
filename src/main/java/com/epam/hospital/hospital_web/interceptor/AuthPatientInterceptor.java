package com.epam.hospital.hospital_web.interceptor;

import com.epam.hospital.hospital_web.manager.UsersManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthPatientInterceptor extends HandlerInterceptorAdapter {

    private final UsersManager usersManager;

    @Autowired
    public AuthPatientInterceptor(UsersManager usersManager) {
        this.usersManager = usersManager;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (usersManager.getUsers() == null) {
            response.sendRedirect("/login_patient");
            return false;
        }
        return true;
    }
}

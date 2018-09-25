package com.epam.hospital.hospital_web.interceptor;

import com.epam.hospital.hospital_web.manager.UsersManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class PatientAddingHandlerInterceptor extends HandlerInterceptorAdapter {

    private final UsersManager usersManager;

    @Autowired
    public PatientAddingHandlerInterceptor(UsersManager usersManager) {
        this.usersManager = usersManager;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView != null) {
            modelAndView.getModel().put("user", usersManager.getUsers());
        }
    }
}

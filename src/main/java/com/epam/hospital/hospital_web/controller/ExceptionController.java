package com.epam.hospital.hospital_web.controller;

import com.epam.hospital.hospital_web.exception.InvalidPasswordException;
import com.epam.hospital.hospital_web.exception.UserNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.management.relation.RoleNotFoundException;

@Controller
public class ExceptionController {


    @ExceptionHandler(UserNotFoundException.class)
    public ModelAndView handleUserNotFoundException(UserNotFoundException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("error", "Логин не верный");
        return modelAndView;
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ModelAndView handleInvalidPasswordException(InvalidPasswordException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("error", "Пароль не верный");
        return modelAndView;
    }
}

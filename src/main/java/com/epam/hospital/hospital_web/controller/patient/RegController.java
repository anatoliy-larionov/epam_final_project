package com.epam.hospital.hospital_web.controller.patient;

import com.epam.hospital.hospital_web.manager.UsersManager;
import com.epam.hospital.hospital_web.entity.Users;
import com.epam.hospital.hospital_web.exception.UserAlreadyExistsException;
import com.epam.hospital.hospital_web.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegController {

    private final UsersManager usersManager;

    private final UsersService usersService;

    @Autowired
    public RegController(UsersService usersService, UsersManager usersManager) {
        this.usersService = usersService;
        this.usersManager = usersManager;
    }

    @GetMapping("/registration")
    public String showReg() {
        return "registration";
    }

    @PostMapping("/registration")
    public String register(@Valid Users user){
        usersService.add(user);
        usersManager.setUsers(user);
        return "redirect:/index";
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public String handlerUserAlreadyExistsException(Model model) {
        model.addAttribute("errorUserAlreadyExistsException", "Пользователь уже зарегистрирован");
        return "registration";
    }
}

package com.epam.hospital.hospital_web.controller.patient;

import com.epam.hospital.hospital_web.entity.Users;
import com.epam.hospital.hospital_web.manager.UsersManager;
import com.epam.hospital.hospital_web.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AuthPatientController {

    private final UsersService usersService;

    private final UsersManager usersManager;

    @Autowired
    public AuthPatientController(UsersManager usersManager, UsersService usersService) {
        this.usersManager = usersManager;
        this.usersService = usersService;
    }

    @GetMapping("/login_patient")
    public String showLogin(Model model) {
        model.addAttribute("user", new Users());
        return "patient/login_patient";
    }

    @PostMapping("/login_patient")
    public String authorize(@Valid Users user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "login_patient";
        }

        Users foundUser = usersService.authenticate(user);
        usersManager.setUsers(foundUser);

        return "redirect:/info_diagnosis";
    }

}

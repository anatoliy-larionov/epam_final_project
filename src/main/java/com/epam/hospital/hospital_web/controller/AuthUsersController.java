package com.epam.hospital.hospital_web.controller;

import com.epam.hospital.hospital_web.entity.Role;
import com.epam.hospital.hospital_web.entity.Users;
import com.epam.hospital.hospital_web.exception.InvalidPasswordException;
import com.epam.hospital.hospital_web.exception.UserNotFoundException;
import com.epam.hospital.hospital_web.service.RoleService;
import com.epam.hospital.hospital_web.service.UsersService;
import com.epam.hospital.hospital_web.manager.UsersManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.management.relation.RoleNotFoundException;
import javax.validation.Valid;

@Controller
public class AuthUsersController {

    private final RoleService roleService;

    private final UsersService usersService;

    private final UsersManager usersManager;

    @Autowired
    public AuthUsersController(RoleService roleService, UsersService usersService,
                               UsersManager usersManager) {
        this.roleService = roleService;
        this.usersService = usersService;
        this.usersManager = usersManager;
    }

    @GetMapping("/login")
    public String showDoctor(Model model) {
        model.addAttribute("user", new Users());
        model.addAttribute("role", new Users());
        return "/login";
    }

    @PostMapping("/login")
    public String authorize(@Valid Users user, Role roles, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/login";
        }

        Users foundUser = usersService.authenticate(user);
        usersManager.setUsers(foundUser);

        Role foundRole = this.roleService.findByRolePersonal(roles.getRolePersonal());

        if (foundUser.getIdUser().equals(foundRole.getIdRole())) {
            if (foundRole.getRolePersonal().equals("DOCTOR")) {
                return "redirect:/add_diagnosis";

            } else if (foundRole.getRolePersonal().equals("NURSE")) {
                return "redirect:/treatment";
            }
        }

        return "redirect:/login";
    }
}

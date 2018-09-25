package com.epam.hospital.hospital_web.controller.doctor;

import com.epam.hospital.hospital_web.entity.Patient;
import com.epam.hospital.hospital_web.entity.Users;
import com.epam.hospital.hospital_web.service.PatientService;
import com.epam.hospital.hospital_web.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ListUsersController {

    private final PatientService patientService;

    private final UsersService usersService;

    @Autowired
    public ListUsersController(UsersService usersService, PatientService patientService) {
        this.usersService = usersService;
        this.patientService = patientService;
    }

    @GetMapping("/list_users")
    public String listUsers(Model model) {
        List<Users> users = usersService.findAll();
        List<Patient> patients = patientService.findAll();
        model.addAttribute("users", users);
        model.addAttribute("patients", patients);
        
        return "doctor/list_users";
    }

    @PostMapping("list_users/addUser")
    public String addPatient(Model model, Users users) {
        usersService.add(users);

        model.addAttribute("users", users);

        return "redirect:/list_users";
    }

    @PostMapping("list_users/addIdPatient")
    public String addIdPatient(Model model, Patient patient) {
        patientService.add(patient);

        model.addAttribute("patient", patient);

        return "redirect:/list_users";
    }
}

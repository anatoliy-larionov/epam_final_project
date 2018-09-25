package com.epam.hospital.hospital_web.controller.patient;

import com.epam.hospital.hospital_web.entity.Patient;
import com.epam.hospital.hospital_web.entity.Treatment;
import com.epam.hospital.hospital_web.entity.Users;
import com.epam.hospital.hospital_web.service.PatientService;
import com.epam.hospital.hospital_web.service.TreatmentService;
import com.epam.hospital.hospital_web.manager.UsersManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class InfoDiagnosisController {

    private final PatientService patientService;

    private final TreatmentService treatmentService;

    private final UsersManager usersManager;

    @Autowired
    public InfoDiagnosisController(PatientService patientService, TreatmentService treatmentService,
                                   UsersManager usersManager) {
        this.patientService = patientService;
        this.treatmentService = treatmentService;
        this.usersManager = usersManager;
    }

    @GetMapping("info_diagnosis")
    public String info(Model model) {

        Users users = usersManager.getUsers();
        Patient patient = patientService.findPatientByPatientId(users.getIdUser());
        List<Treatment> treatment = treatmentService.findPatientById(patient.getIdPatient());

        model.addAttribute("users", users);
        model.addAttribute("patient", patient);
        model.addAttribute("treatment", treatment);

        return "patient/info_diagnosis";
    }


    @GetMapping("info")
    public String infoForPatient(Model model) {
        Users users = usersManager.getUsers();

        model.addAttribute("users", users);

        return "redirect:/info";
    }
}

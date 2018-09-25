package com.epam.hospital.hospital_web.controller.doctor;

import com.epam.hospital.hospital_web.entity.Treatment;
import com.epam.hospital.hospital_web.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AddDiagnosisController {

    private final TreatmentService treatmentService;

    @Autowired
    public AddDiagnosisController(TreatmentService treatmentService) {
        this.treatmentService = treatmentService;
    }

    @GetMapping("add_diagnosis")
    public String listTreatment(Model model) {
        List<Treatment> treatments = this.treatmentService.findAll();
        model.addAttribute("treatments", treatments);

        return "doctor/add_diagnosis";
    }

    @PostMapping("add_diagnosis/add")
    public String addDiagnosis(Model model, Treatment treatment) {
        treatmentService.add(treatment);
        model.addAttribute("treatment", treatment);

        return "redirect:/add_diagnosis";
    }
}

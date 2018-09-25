package com.epam.hospital.hospital_web.controller.doctor;

import com.epam.hospital.hospital_web.entity.Treatment;
import com.epam.hospital.hospital_web.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AddTreatmentController {

    private final TreatmentService treatmentService;

    @Autowired
    public AddTreatmentController(TreatmentService treatmentService) {
        this.treatmentService = treatmentService;
    }

    @GetMapping("add_treatment")
    public String listTreatment(Model model) {
        List<Treatment> treatments = this.treatmentService.findAll();
        model.addAttribute("treatments", treatments);

        return "doctor/add_treatment";
    }

    @RequestMapping(value = "add_treatment", params = {"idTreatment"}, method = RequestMethod.POST)
    public String addTreatment(Model model, Treatment treatment,
                               @RequestParam(value = "idTreatment") Long idTreatment) {
        treatmentService.updateTreatmentPatient(treatment, idTreatment);

        return listTreatment(model);
    }
}

package com.epam.hospital.hospital_web.controller.nurse;

import com.epam.hospital.hospital_web.entity.Treatment;
import com.epam.hospital.hospital_web.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TreatmentController {

    private final TreatmentService treatmentService;

    @Autowired
    public TreatmentController(TreatmentService treatmentService) {
        this.treatmentService = treatmentService;
    }


    @GetMapping("treatment")
    public String listTreatmentNurse(Model model) {
        List<Treatment> treatments = this.treatmentService.findAll();
        model.addAttribute("treatments", treatments);

        return "nurse/treatment";
    }

    @RequestMapping(value = "treatment", params = {"idTreatment"}, method = RequestMethod.POST)
    public String addTreatmentNurse(Model model, Treatment treatment,
                               @RequestParam(value = "idTreatment") Long idTreatment) {
        treatmentService.updateTreatmentPatient(treatment, idTreatment);

        return listTreatmentNurse(model);
    }
}

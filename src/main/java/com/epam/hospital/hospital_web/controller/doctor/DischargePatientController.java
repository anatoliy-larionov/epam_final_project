package com.epam.hospital.hospital_web.controller.doctor;

import com.epam.hospital.hospital_web.entity.Treatment;
import com.epam.hospital.hospital_web.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DischargePatientController {

    private final TreatmentService treatmentService;

    @Autowired
    public DischargePatientController(TreatmentService treatmentService) {
        this.treatmentService = treatmentService;
    }

    @GetMapping("discharge")
    public String listDischarge(Model model) {
        List<Treatment> treatments = this.treatmentService.findAll();
        model.addAttribute("treatments", treatments);

        return "doctor/discharge";
    }

    @RequestMapping(value = "discharge", params = {"idTreatment"}, method = RequestMethod.POST)
    public String addDischarge(Model model, Treatment treatment,
                               @RequestParam(value = "idTreatment") Long idTreatment) {
        treatmentService.updateDischargePatient(treatment, idTreatment);

        return listDischarge(model);
    }
}

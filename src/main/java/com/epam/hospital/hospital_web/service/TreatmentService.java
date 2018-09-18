package com.epam.hospital.hospital_web.service;

import com.epam.hospital.hospital_web.entity.Treatment;

import java.util.List;

public interface TreatmentService extends BasicService<Treatment> {

    List<Treatment> findPatientById(Long patientId);
    void updateDischargePatient(Treatment treatment, Long idTreatment);
    void updateTreatmentPatient(Treatment treatment, Long idTreatment);
    void editDischargePatient(Treatment treatment, Long idTreatment);
}

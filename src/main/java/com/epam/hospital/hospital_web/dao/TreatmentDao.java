package com.epam.hospital.hospital_web.dao;

import com.epam.hospital.hospital_web.entity.Treatment;

import java.util.List;

public interface TreatmentDao extends BasicDao<Treatment> {

    List<Treatment> findPatientById(Long patientId);
    void updateDischargePatient(Treatment treatment, Long idTreatment);
    void updateTreatmentPatient(Treatment treatment, Long idTreatment);
    void editDischargePatient(Treatment treatment, Long idTreatment);
}

package com.epam.hospital.hospital_web.dao;

import com.epam.hospital.hospital_web.entity.Patient;

public interface PatientDao extends BasicDao<Patient> {

    Patient findPatientByPatientId(Long patientIdUser);
}

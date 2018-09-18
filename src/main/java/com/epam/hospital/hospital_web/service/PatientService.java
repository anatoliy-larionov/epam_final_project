package com.epam.hospital.hospital_web.service;

import com.epam.hospital.hospital_web.dao.BasicDao;
import com.epam.hospital.hospital_web.entity.Patient;

public interface PatientService extends BasicService<Patient> {

    Patient findPatientByPatientId(Long patientIdUser);
    Patient authPatId(Patient patient);
}

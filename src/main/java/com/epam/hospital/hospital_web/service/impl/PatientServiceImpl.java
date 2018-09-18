package com.epam.hospital.hospital_web.service.impl;

import com.epam.hospital.hospital_web.dao.PatientDao;
import com.epam.hospital.hospital_web.entity.Patient;
import com.epam.hospital.hospital_web.entity.Users;
import com.epam.hospital.hospital_web.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientDao patientDao;

    @Autowired
    public PatientServiceImpl(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    @Override
    public Patient findPatientByPatientId(Long patientIdUser) {
        return this.patientDao.findPatientByPatientId(patientIdUser);
    }

    @Override
    public List<Patient> findAll() {
        return this.patientDao.findAll();
    }

    @Override
    public Patient findById(Long idPatient) {
        return this.patientDao.findById(idPatient);
    }

    @Override
    public void add(Patient patient) {
        this.patientDao.add(patient);
    }

    public Patient authPatId(Patient patient) {
        Patient foundIdPatient = this.findPatientByPatientId(patient.getPatientIdUser());
        Users users = new Users();
        if  (foundIdPatient.getPatientIdUser().equals(users.getIdUser())) {
            System.out.println();
        }

        return foundIdPatient;
    }
}

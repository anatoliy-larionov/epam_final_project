package com.epam.hospital.hospital_web.service.impl;

import com.epam.hospital.hospital_web.dao.TreatmentDao;
import com.epam.hospital.hospital_web.entity.Treatment;
import com.epam.hospital.hospital_web.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreatmentServiceImpl implements TreatmentService {

    private final TreatmentDao treatmentDao;

    @Autowired
    public TreatmentServiceImpl(TreatmentDao treatmentDao) {
        this.treatmentDao = treatmentDao;
    }

    @Override
    public List<Treatment> findPatientById(Long patientId) {
        return this.treatmentDao.findPatientById(patientId);
    }

    @Override
    public void updateDischargePatient(Treatment treatment, Long idTreatment) {
        this.treatmentDao.updateDischargePatient(treatment, idTreatment);
    }

    @Override
    public void updateTreatmentPatient(Treatment treatment, Long idTreatment) {
        this.treatmentDao.updateTreatmentPatient(treatment, idTreatment);
    }

    @Override
    public void editDischargePatient(Treatment treatment, Long idTreatment) {
        this.treatmentDao.editDischargePatient(treatment, idTreatment);
    }

    @Override
    public List<Treatment> findAll() {
        return this.treatmentDao.findAll();
    }

    @Override
    public Treatment findById(Long idTreatment) {
        return this.treatmentDao.findById(idTreatment);
    }

    @Override
    public void add(Treatment treatment) {
        this.treatmentDao.add(treatment);
    }
}

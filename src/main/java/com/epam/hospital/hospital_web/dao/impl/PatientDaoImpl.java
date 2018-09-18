package com.epam.hospital.hospital_web.dao.impl;

import com.epam.hospital.hospital_web.dao.PatientDao;
import com.epam.hospital.hospital_web.dao.mapper.PatientMapper;
import com.epam.hospital.hospital_web.dao.mapper.UsersMapper;
import com.epam.hospital.hospital_web.entity.Patient;
import com.epam.hospital.hospital_web.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientDaoImpl implements PatientDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PatientDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Patient findPatientByPatientId(Long patientIdUser) {
        return this.jdbcTemplate.queryForObject("SELECT * FROM patient WHERE patient_id_user = ?",
                new PatientMapper(), patientIdUser);
    }

    @Override
    public List<Patient> findAll() {
        return this.jdbcTemplate.query("SELECT * FROM patient", new PatientMapper());
    }

    @Override
    public Patient findById(Long idPatient) {
        return this.jdbcTemplate.queryForObject("SELECT * FROM patient WHERE id_patient = ?",
                new Object[]{idPatient}, new PatientMapper());
    }

    @Override
    public void add(Patient patient) {
        this.jdbcTemplate.update("INSERT INTO patient (patient_id_user) VALUES " +
                "(?)", patient.getPatientIdUser());
    }
}

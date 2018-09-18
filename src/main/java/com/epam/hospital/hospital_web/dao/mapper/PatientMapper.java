package com.epam.hospital.hospital_web.dao.mapper;

import com.epam.hospital.hospital_web.entity.Patient;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientMapper implements RowMapper<Patient> {

    @Override
    public Patient mapRow(ResultSet resultSet, int i) throws SQLException {
        Patient patient = new Patient();
        patient.setIdPatient(resultSet.getLong("id_patient"));
        patient.setPatientIdUser(resultSet.getLong("patient_id_user"));
        return patient;
    }
}

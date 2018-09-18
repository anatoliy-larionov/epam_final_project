package com.epam.hospital.hospital_web.dao.mapper;

import com.epam.hospital.hospital_web.entity.Treatment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TreatmentMapper implements RowMapper<Treatment> {

    @Override
    public Treatment mapRow(ResultSet resultSet, int i) throws SQLException {
        Treatment treatment = new Treatment();
        treatment.setIdTreatment(resultSet.getLong("id_treatment"));
        treatment.setPatientId(resultSet.getLong("patient_id"));
        treatment.setRoleId(resultSet.getLong("role_id"));
        treatment.setDateReception(resultSet.getDate("date_reception"));
        treatment.setPreliminaryDiagnosis(resultSet.getString("preliminary_diagnosis"));
        treatment.setNameMedicines(resultSet.getString("name_medicines"));
        treatment.setTypeTreatment(resultSet.getString("type_treatment"));
        treatment.setDateDischarge(resultSet.getDate("date_discharge"));
        treatment.setFinalDiagnosis(resultSet.getString("final_diagnosis"));
        return treatment;
    }
}

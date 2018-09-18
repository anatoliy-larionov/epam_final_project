package com.epam.hospital.hospital_web.dao.impl;

import com.epam.hospital.hospital_web.dao.TreatmentDao;
import com.epam.hospital.hospital_web.dao.mapper.TreatmentMapper;
import com.epam.hospital.hospital_web.entity.Treatment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TreatmentDaoImpl implements TreatmentDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TreatmentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Treatment> findPatientById(Long patientId) {
        return this.jdbcTemplate.query("SELECT * FROM treatment WHERE patient_id = ?",
                new Object[]{patientId}, new TreatmentMapper());
    }

    @Override
    public void updateDischargePatient(Treatment treatment, Long idTreatment) {
        this.jdbcTemplate.update("UPDATE treatment SET date_discharge = ?, final_diagnosis = ? " +
                "WHERE id_treatment = ?", treatment.getDateDischarge(), treatment.getFinalDiagnosis(), idTreatment);
    }

    @Override
    public void updateTreatmentPatient(Treatment treatment, Long idTreatment) {
        this.jdbcTemplate.update("UPDATE treatment SET name_medicines = ?, type_treatment = ? " +
                "WHERE id_treatment = ?", treatment.getNameMedicines(), treatment.getTypeTreatment(), idTreatment);
    }

    @Override
    public void editDischargePatient(Treatment treatment, Long idTreatment) {
        this.jdbcTemplate.update("UPDATE treatment SET final_diagnosis = ? WHERE id_treatment = ?",
                treatment.getFinalDiagnosis(), idTreatment);
    }

    @Override
    public List<Treatment> findAll() {
        return this.jdbcTemplate.query("SELECT * FROM treatment", new TreatmentMapper());
    }

    @Override
    public Treatment findById(Long idTreatment) {
        return this.jdbcTemplate.queryForObject("SELECT * FROM treatment WHERE id_treatment = ?",
                new Object[]{idTreatment}, new TreatmentMapper());
    }

    @Override
    public void add(Treatment treatment) {
        this.jdbcTemplate.update("INSERT INTO treatment (patient_id, role_id, date_reception, " +
                "preliminary_diagnosis) VALUES (?, ?, ?, ?)", treatment.getPatientId(), treatment.getRoleId(),
                treatment.getDateReception(), treatment.getPreliminaryDiagnosis());
    }
}

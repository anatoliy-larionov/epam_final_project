package com.epam.hospital.hospital_web.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "treatment")
public class Treatment implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_treatment")
    private Long idTreatment;

    @Column(name = "patient_id")
    private Long patientId;

    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "date_reception")
    private Date dateReception;

    @Column(name = "preliminary_diagnosis")
    private String preliminaryDiagnosis;

    @Column(name = "name_medicines")
    private String nameMedicines;

    @Column(name = "type_treatment")
    private String typeTreatment;

    @Column(name = "date_discharge")
    private Date dateDischarge;

    @Column(name = "final_diagnosis")
    private String finalDiagnosis;

    public Treatment() {
    }

    public Long getIdTreatment() {
        return idTreatment;
    }

    public void setIdTreatment(Long idTreatment) {
        this.idTreatment = idTreatment;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Date getDateReception() {
        return dateReception;
    }

    public void setDateReception(Date dateReception) {
        this.dateReception = dateReception;
    }

    public String getPreliminaryDiagnosis() {
        return preliminaryDiagnosis;
    }

    public void setPreliminaryDiagnosis(String preliminaryDiagnosis) {
        this.preliminaryDiagnosis = preliminaryDiagnosis;
    }

    public String getNameMedicines() {
        return nameMedicines;
    }

    public void setNameMedicines(String nameMedicines) {
        this.nameMedicines = nameMedicines;
    }

    public String getTypeTreatment() {
        return typeTreatment;
    }

    public void setTypeTreatment(String typeTreatment) {
        this.typeTreatment = typeTreatment;
    }

    public Date getDateDischarge() {
        return dateDischarge;
    }

    public void setDateDischarge(Date dateDischarge) {
        this.dateDischarge = dateDischarge;
    }

    public String getFinalDiagnosis() {
        return finalDiagnosis;
    }

    public void setFinalDiagnosis(String finalDiagnosis) {
        this.finalDiagnosis = finalDiagnosis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Treatment treatment = (Treatment) o;
        return Objects.equals(idTreatment, treatment.idTreatment) &&
                Objects.equals(patientId, treatment.patientId) &&
                Objects.equals(roleId, treatment.roleId) &&
                Objects.equals(dateReception, treatment.dateReception) &&
                Objects.equals(preliminaryDiagnosis, treatment.preliminaryDiagnosis) &&
                Objects.equals(nameMedicines, treatment.nameMedicines) &&
                Objects.equals(typeTreatment, treatment.typeTreatment) &&
                Objects.equals(dateDischarge, treatment.dateDischarge) &&
                Objects.equals(finalDiagnosis, treatment.finalDiagnosis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTreatment, patientId, roleId, dateReception, preliminaryDiagnosis, nameMedicines, typeTreatment, dateDischarge, finalDiagnosis);
    }

    @Override
    public String toString() {
        return "Treatment{" +
                "idTreatment=" + idTreatment +
                ", patientId=" + patientId +
                ", roleId=" + roleId +
                ", dateReception=" + dateReception +
                ", preliminaryDiagnosis='" + preliminaryDiagnosis + '\'' +
                ", nameMedicines='" + nameMedicines + '\'' +
                ", typeTreatment='" + typeTreatment + '\'' +
                ", dateDischarge=" + dateDischarge +
                ", finalDiagnosis='" + finalDiagnosis + '\'' +
                '}';
    }
}

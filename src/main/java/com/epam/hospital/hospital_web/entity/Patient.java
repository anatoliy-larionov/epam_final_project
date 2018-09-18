package com.epam.hospital.hospital_web.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "patient")
public class Patient implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_patient")
    private Long idPatient;

    @Column(name = "patient_id_user")
    private Long patientIdUser;

    public Patient() {
    }

    public Long getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Long idPatient) {
        this.idPatient = idPatient;
    }

    public Long getPatientIdUser() {
        return patientIdUser;
    }

    public void setPatientIdUser(Long patientIdUser) {
        this.patientIdUser = patientIdUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(idPatient, patient.idPatient) &&
                Objects.equals(patientIdUser, patient.patientIdUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPatient, patientIdUser);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "idPatient=" + idPatient +
                ", patientIdUser=" + patientIdUser +
                '}';
    }
}

package com.epam.hospital.hospital_web.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "users")
public class Users implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_users")
    private Long idUser;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @NotNull
    @Size(min = 3, max = 10)
    @Column(name = "login")
    private String login;

    @NotNull
    @Size(min = 3, max = 10)
    @Column(name = "password")
    private String password;

    private Role role;

    public Users() {
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(idUser, users.idUser) &&
                Objects.equals(lastName, users.lastName) &&
                Objects.equals(firstName, users.firstName) &&
                Objects.equals(patronymic, users.patronymic) &&
                Objects.equals(dateOfBirth, users.dateOfBirth) &&
                Objects.equals(login, users.login) &&
                Objects.equals(password, users.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, lastName, firstName, patronymic, dateOfBirth, login, password);
    }

    @Override
    public String toString() {
        return "Users{" +
                "idUser=" + idUser +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

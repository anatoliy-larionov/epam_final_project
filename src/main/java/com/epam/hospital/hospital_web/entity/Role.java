package com.epam.hospital.hospital_web.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "role")
public class Role implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_role")
    private Long idRole;

    @Column(name = "role_personal")
    private String rolePersonal;

    public Role() {
    }

    public Role(String rolePersonal) {
        this.rolePersonal = rolePersonal;
    }

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public String getRolePersonal() {
        return rolePersonal;
    }

    public void setRolePersonal(String rolePersonal) {
        this.rolePersonal = rolePersonal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(idRole, role.idRole) &&
                Objects.equals(rolePersonal, role.rolePersonal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRole, rolePersonal);
    }

    @Override
    public String toString() {
        return "Role{" +
                "idRole=" + idRole +
                ", rolePersonal='" + rolePersonal + '\'' +
                '}';
    }
}

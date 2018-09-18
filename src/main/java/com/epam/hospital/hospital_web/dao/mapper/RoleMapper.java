package com.epam.hospital.hospital_web.dao.mapper;

import com.epam.hospital.hospital_web.entity.Role;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleMapper implements RowMapper<Role> {

    @Override
    public Role mapRow(ResultSet resultSet, int i) throws SQLException {
        Role role = new Role();
        role.setIdRole(resultSet.getLong("id_role"));
        role.setRolePersonal(resultSet.getString("personal_role"));
        return role;
    }
}

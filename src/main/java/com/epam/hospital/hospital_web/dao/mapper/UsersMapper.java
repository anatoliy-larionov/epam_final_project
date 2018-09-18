package com.epam.hospital.hospital_web.dao.mapper;

import com.epam.hospital.hospital_web.entity.Users;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersMapper implements RowMapper<Users> {

    @Override
    public Users mapRow(ResultSet resultSet, int i) throws SQLException {
        Users users = new Users();
        users.setIdUser(resultSet.getLong("id_users"));
        users.setLastName(resultSet.getString("last_name"));
        users.setFirstName(resultSet.getString("first_name"));
        users.setPatronymic(resultSet.getString("patronymic"));
        users.setDateOfBirth(resultSet.getDate("date_of_birth"));
        users.setLogin(resultSet.getString("login"));
        users.setPassword(resultSet.getString("password"));
        return users;
    }
}

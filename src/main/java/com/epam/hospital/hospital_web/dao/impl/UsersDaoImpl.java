package com.epam.hospital.hospital_web.dao.impl;

import com.epam.hospital.hospital_web.dao.UsersDao;
import com.epam.hospital.hospital_web.dao.mapper.UsersMapper;
import com.epam.hospital.hospital_web.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersDaoImpl implements UsersDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UsersDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Users findUserByLogin(String login) {
        try {
            return this.jdbcTemplate.queryForObject("SELECT * FROM users " +
                    "WHERE login = ?", new UsersMapper(), login);
        }catch (EmptyResultDataAccessException ignored) {
            return null;
        }
    }

    @Override
    public List<Users> findAll() {
        return this.jdbcTemplate.query("SELECT * FROM users", new UsersMapper());
    }

    @Override
    public Users findById(Long idUser) {
        return this.jdbcTemplate.queryForObject("SELECT * FROM users WHERE id_users = ?", new Object[]{idUser},
                new UsersMapper());
    }

    @Override
    public void add(Users users) {
        this.jdbcTemplate.update("INSERT INTO users (last_name, first_name, patronymic, date_of_birth, " +
                "login, password) VALUES (?, ?, ?, ?, ?, ?)", users.getLastName(), users.getFirstName(),
                users.getPatronymic(), users.getDateOfBirth(), users.getLogin(), users.getPassword());
    }
}

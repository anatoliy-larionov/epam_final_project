package com.epam.hospital.hospital_web.dao;

import com.epam.hospital.hospital_web.entity.Users;

public interface UsersDao extends BasicDao<Users> {

    Users findUserByLogin(String login);
}

package com.epam.hospital.hospital_web.service;

import com.epam.hospital.hospital_web.entity.Users;

public interface UsersService extends BasicService<Users> {

    Users findUserByLogin(String login);
    Users authenticate(Users users);
}

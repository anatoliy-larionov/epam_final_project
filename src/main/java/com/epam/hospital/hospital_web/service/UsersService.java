package com.epam.hospital.hospital_web.service;

import com.epam.hospital.hospital_web.entity.Patient;
import com.epam.hospital.hospital_web.entity.Users;
import com.epam.hospital.hospital_web.exception.InvalidPasswordException;
import com.epam.hospital.hospital_web.exception.UserNotFoundException;

import javax.management.relation.RoleNotFoundException;

public interface UsersService extends BasicService<Users> {

    Users findUserByLogin(String login);
    Users authenticate(Users users) throws UserNotFoundException, InvalidPasswordException, RoleNotFoundException;
}

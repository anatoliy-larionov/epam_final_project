package com.epam.hospital.hospital_web.service.impl;

import com.epam.hospital.hospital_web.dao.UsersDao;
import com.epam.hospital.hospital_web.entity.Users;
import com.epam.hospital.hospital_web.exception.InvalidPasswordException;
import com.epam.hospital.hospital_web.exception.UserNotFoundException;
import com.epam.hospital.hospital_web.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersDao usersDao;

    @Autowired
    public UsersServiceImpl(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    @Override
    public Users findUserByLogin(String login) {
        return this.usersDao.findUserByLogin(login);
    }

    @Override
    public List<Users> findAll() {
        return this.usersDao.findAll();
    }

    @Override
    public Users findById(Long idUser) {
        return this.usersDao.findById(idUser);
    }

    @Override
    public void add(Users users) {
        this.usersDao.add(users);
    }

    public Users authenticate(Users users) {

        Users foundUser = this.findUserByLogin(users.getLogin());
        if (foundUser == null) {
            throw new UserNotFoundException();
        }

        if (!foundUser.getPassword().equals(users.getPassword())) {
            throw new InvalidPasswordException();
        }

        return foundUser;
    }
}

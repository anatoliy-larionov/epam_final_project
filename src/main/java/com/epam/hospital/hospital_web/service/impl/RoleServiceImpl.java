package com.epam.hospital.hospital_web.service.impl;

import com.epam.hospital.hospital_web.dao.RoleDao;
import com.epam.hospital.hospital_web.entity.Role;
import com.epam.hospital.hospital_web.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role findUserByRoleId(Long roleIdUser) {
        return this.roleDao.findUserByRoleId(roleIdUser);
    }

    @Override
    public Role findByRolePersonal(String role) {
        return this.roleDao.findByRolePersonal(role);
    }

    @Override
    public List<Role> findAll() {
        return this.roleDao.findAll();
    }

    @Override
    public Role findById(Long idRole) {
        return this.roleDao.findById(idRole);
    }

    @Override
    public void add(Role role) {
        this.roleDao.add(role);
    }
}

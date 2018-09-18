package com.epam.hospital.hospital_web.dao;

import com.epam.hospital.hospital_web.entity.Role;

import java.util.List;

public interface RoleDao extends BasicDao<Role> {

    Role findUserByRoleId(Long roleIdUser);
    Role findByRolePersonal(String role);
}

package com.epam.hospital.hospital_web.service;

import com.epam.hospital.hospital_web.entity.Role;

import javax.management.relation.RoleNotFoundException;
import java.util.List;

public interface RoleService extends BasicService<Role> {

    Role findUserByRoleId(Long roleIdUser);
    Role findByRolePersonal(String role);
/*    Role roleAuth(Role role) throws RoleNotFoundException;*/

}

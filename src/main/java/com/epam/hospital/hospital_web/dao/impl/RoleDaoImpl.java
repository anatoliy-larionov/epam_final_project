package com.epam.hospital.hospital_web.dao.impl;

import com.epam.hospital.hospital_web.dao.RoleDao;
import com.epam.hospital.hospital_web.dao.mapper.RoleMapper;
import com.epam.hospital.hospital_web.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RoleDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Role findUserByRoleId(Long roleIdUser) {
        return this.jdbcTemplate.queryForObject("SELECT * FROM role WHERE id_role = ?",
                new RoleMapper(), roleIdUser );
    }

    @Override
    public Role findByRolePersonal(String role) {
        return this.jdbcTemplate.queryForObject("select * from users inner join role_users user2 " +
                        "on users.id_users = user2.users_id inner join role r on user2.role_id = r.id_role " +
                        "where personal_role = ?;",
                new RoleMapper(), role);
    }

    @Override
    public List<Role> findAll() {
        return this.jdbcTemplate.query("SELECT * FROM role", new RoleMapper());
    }

    @Override
    public Role findById(Long idRole) {
        return this.jdbcTemplate.queryForObject("SELECT * FROM role WHERE id_role = ?",
                new Object[]{idRole}, new RoleMapper());
    }

    @Override
    public void add(Role role) {
        this.jdbcTemplate.update("INSERT INTO role (personal_role) VALUES " +
                "(?)", role.getRolePersonal());
    }
}

package com.epam.hospital.hospital_web.manager;

import com.epam.hospital.hospital_web.entity.Role;
import com.epam.hospital.hospital_web.entity.Users;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class UsersManager {

    private Users users;

    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}

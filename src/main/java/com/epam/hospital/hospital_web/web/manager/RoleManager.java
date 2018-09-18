package com.epam.hospital.hospital_web.web.manager;

import com.epam.hospital.hospital_web.entity.Role;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class RoleManager {

    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

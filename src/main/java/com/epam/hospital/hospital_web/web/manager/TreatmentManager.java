package com.epam.hospital.hospital_web.web.manager;

import com.epam.hospital.hospital_web.entity.Treatment;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class TreatmentManager {

    private Treatment treatment;

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }
}

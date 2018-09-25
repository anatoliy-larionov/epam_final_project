package com.epam.hospital.hospital_web.config;

import com.epam.hospital.hospital_web.interceptor.AuthPatientInterceptor;
import com.epam.hospital.hospital_web.interceptor.AuthPersonaInterceptor;
import com.epam.hospital.hospital_web.interceptor.PatientAddingHandlerInterceptor;
import com.epam.hospital.hospital_web.interceptor.PersonalAddingHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

    private final AuthPersonaInterceptor personaInterceptor;

    private final PersonalAddingHandlerInterceptor personalAddingHandlerInterceptor;

    private final AuthPatientInterceptor patientInterceptor;

    private final PatientAddingHandlerInterceptor patientAddingHandlerInterceptor;

    @Autowired
    public WebConfiguration(
            AuthPersonaInterceptor doctorInterceptor,
            PersonalAddingHandlerInterceptor personalAddingHandlerInterceptor, AuthPatientInterceptor patientInterceptor, PatientAddingHandlerInterceptor patientAddingHandlerInterceptor) {
        this.personaInterceptor = doctorInterceptor;
        this.personalAddingHandlerInterceptor = personalAddingHandlerInterceptor;
        this.patientInterceptor = patientInterceptor;
        this.patientAddingHandlerInterceptor = patientAddingHandlerInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(personaInterceptor)
                .addPathPatterns("/add_diagnosis/**").addPathPatterns("/add_treatment")
                .addPathPatterns("/discharge").addPathPatterns("/list_users").addPathPatterns("/treatment/**");
        registry.addInterceptor(personalAddingHandlerInterceptor)
                .addPathPatterns("/**");

        registry.addInterceptor(patientInterceptor)
                .addPathPatterns("/info_diagnosis/**");
        registry.addInterceptor(personalAddingHandlerInterceptor)
                .addPathPatterns("/**");
    }
}
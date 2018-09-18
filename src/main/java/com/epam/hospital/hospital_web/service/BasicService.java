package com.epam.hospital.hospital_web.service;

import java.io.Serializable;
import java.util.List;

public interface BasicService<T extends Serializable> {

    List<T> findAll();
    T findById(Long id);
    void add(T o);
}

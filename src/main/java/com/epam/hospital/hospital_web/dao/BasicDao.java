package com.epam.hospital.hospital_web.dao;

import java.io.Serializable;
import java.util.List;

public interface BasicDao<T extends Serializable> {

    List<T> findAll();
    T findById(Long id);
    void add(T o);
}

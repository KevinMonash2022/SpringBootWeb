package com.kevin.curd.dao;

import com.kevin.curd.entity.Student;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

}

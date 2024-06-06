package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

    Student findVyID(int id);

    List<Student> findAll();

    List<Student> bylastname(String thelastname);

    void update(Student theStudent);

    void delete(int id);

    int deleteAll();
}

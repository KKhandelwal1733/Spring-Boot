package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor instructor);

    InstructorDetail findInstructorDetailById(int id);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);
    void deleteInstructorDetailById(int id);
}

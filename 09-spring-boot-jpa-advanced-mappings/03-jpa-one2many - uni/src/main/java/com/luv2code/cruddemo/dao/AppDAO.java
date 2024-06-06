package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {

    void save(Instructor instructor);

    InstructorDetail findInstructorDetailById(int id);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);
    void deleteInstructorDetailById(int id);

    List<Course> findCourseByInstructorid(int id);

    Instructor findInstructorByIdJoinFetch(int id);

    void update(Instructor tempInstructor);

    void update(Course course);

    Course findCourseById(int id);

    void deleteCourse(int id);

    void save(Course course);

    Course findCourseandReviewsbyId(int id);


}

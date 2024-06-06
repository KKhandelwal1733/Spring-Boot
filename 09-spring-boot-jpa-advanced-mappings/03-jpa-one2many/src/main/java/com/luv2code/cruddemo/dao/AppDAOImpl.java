package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO{
    private EntityManager entityManager;


    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;


    }
    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);

    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class,id);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class,id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        Instructor instructor=entityManager.find(Instructor.class,id);

        for(Course course:instructor.getCourses()){
            course.setInstructor(null);
        }

        entityManager.remove(instructor);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        InstructorDetail temp=entityManager.find(InstructorDetail.class,id);
        //remove the associated bidirectional link for deleting only Instructor Details
        temp.getInstructor().setInstructorDetail(null);

        entityManager.remove(temp);
    }

    @Override
    public List<Course> findCourseByInstructorid(int id) {
        TypedQuery<Course> query= entityManager.createQuery("from Course where instructor.id=:data", Course.class);
        query.setParameter("data",id);

        List<Course> courses=query.getResultList();
        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {
        TypedQuery<Instructor> query=entityManager.createQuery("select i from Instructor i "
                +" JOIN FETCH i.courses "
                +"JOIN FETCH i.instructorDetail "+"where i.id=:data", Instructor.class);

        query.setParameter("data",id);
        Instructor instructor=query.getSingleResult();

        return instructor;
    }

    @Override
    @Transactional
    public void update(Instructor tempInstructor) {
        entityManager.merge(tempInstructor);
    }

    @Override
    @Transactional
    public void update(Course course) {
        entityManager.merge(course);

    }

    @Override
    public Course findCourseById(int id) {
        Course tempCourse=entityManager.find(Course.class,id);
        return tempCourse;
    }

    @Override
    @Transactional
    public void deleteCourse(int id) {
        Course tempcourse =entityManager.find(Course.class,id);
        entityManager.remove(tempcourse);
    }
}

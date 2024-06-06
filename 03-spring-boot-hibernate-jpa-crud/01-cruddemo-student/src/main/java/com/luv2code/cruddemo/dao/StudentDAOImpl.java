package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);

    }

    @Override
    public Student findVyID(int id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> thequery=entityManager.createQuery("From Student",Student.class);

        return thequery.getResultList();
    }

    @Override
    public List<Student> bylastname(String thelastname) {
        TypedQuery<Student> thequery=entityManager.createQuery("from Student where lastName=:theData", Student.class);

        thequery.setParameter("theData",thelastname);
        return thequery.getResultList();

    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);

    }

    @Override
    @Transactional
    public void delete(int id) {
        Student thestudent=entityManager.find(Student.class,id);

        entityManager.remove(thestudent);

    }

    @Override
    @Transactional
    public int deleteAll() {
        int number=entityManager.createQuery("delete from Student ").executeUpdate();
        return number;
    }
}

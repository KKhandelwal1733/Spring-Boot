package com.lu2code.sprinboot.cruddemo.dao;

import com.lu2code.sprinboot.cruddemo.entity.Employee;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeedaoImpl implements Employeedao{

    private EntityManager entityManager;

    @Autowired
    public  EmployeedaoImpl(EntityManager theentitymanager){
        entityManager=theentitymanager;
        //return entityManager;
    }
    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> thequery= entityManager.createQuery("from Employee ",Employee.class);

        List<Employee> list=thequery.getResultList();
        return list;
    }

    @Override
    public Employee findbyid(int id) {
        Employee themp=entityManager.find(Employee.class,id);
        return themp;


    }

    @Override
    public Employee save(Employee theemp) {
        Employee emp=entityManager.merge(theemp);
        return emp;
    }

    @Override
    public void deleteById(int theId) {
        Employee themp=entityManager.find(Employee.class,theId);
        entityManager.remove(themp);

    }
}

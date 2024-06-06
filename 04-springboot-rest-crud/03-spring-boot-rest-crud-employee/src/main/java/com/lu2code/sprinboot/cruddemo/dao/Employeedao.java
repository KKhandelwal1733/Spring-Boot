package com.lu2code.sprinboot.cruddemo.dao;

import com.lu2code.sprinboot.cruddemo.entity.Employee;

import java.util.List;

public interface Employeedao {
    List<Employee> findAll();

    Employee findbyid(int id);
    Employee save(Employee theemp);

    void deleteById(int theId);
}

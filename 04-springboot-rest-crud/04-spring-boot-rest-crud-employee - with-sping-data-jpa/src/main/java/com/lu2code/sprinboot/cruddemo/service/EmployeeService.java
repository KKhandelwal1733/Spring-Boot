package com.lu2code.sprinboot.cruddemo.service;

import com.lu2code.sprinboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findbyid(int id);
    Employee save(Employee theemp);

    void deleteById(int theId);
}

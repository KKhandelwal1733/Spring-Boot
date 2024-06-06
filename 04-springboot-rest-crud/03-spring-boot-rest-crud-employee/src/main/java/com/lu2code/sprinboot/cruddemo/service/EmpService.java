package com.lu2code.sprinboot.cruddemo.service;

import com.lu2code.sprinboot.cruddemo.dao.Employeedao;
import com.lu2code.sprinboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpService implements EmployeeService{

    private Employeedao employeedao;
@Autowired
    public EmpService(Employeedao theemployeedao){
        employeedao= theemployeedao;
    }
    @Override
    public List<Employee> findAll() {
    return employeedao.findAll();

    }

    @Override
    public Employee findbyid(int id) {
        return employeedao.findbyid(id);
    }

    @Override
    @Transactional
    public Employee save(Employee theemp) {
        return employeedao.save(theemp);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
    employeedao.deleteById(theId);

    }
}

package com.lu2code.sprinboot.cruddemo.service;

import com.lu2code.sprinboot.cruddemo.dao.EmpRepo;

import com.lu2code.sprinboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService implements EmployeeService{

    private EmpRepo employeerepo;
@Autowired
    public EmpService(EmpRepo theemployeedao){
    employeerepo= theemployeedao;
    }
    @Override
    public List<Employee> findAll() {
    return employeerepo.findAll();

    }

    @Override
    public Employee findbyid(int id) {
        Optional<Employee> result = employeerepo.findById(id);
        Employee theemployee=null;
        if(result.isPresent()){
            theemployee=result.get();
        }
        else
            throw new RuntimeException("Did not find employee id"+id);
        return theemployee;
    }

    @Override

    public Employee save(Employee theemp) {
        return employeerepo.save(theemp);
    }

    @Override

    public void deleteById(int theId) {
        employeerepo.deleteById(theId);

    }
}

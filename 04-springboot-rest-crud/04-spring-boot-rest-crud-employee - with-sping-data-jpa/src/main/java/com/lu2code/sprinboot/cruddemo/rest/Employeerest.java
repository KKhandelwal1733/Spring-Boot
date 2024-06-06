package com.lu2code.sprinboot.cruddemo.rest;

import com.lu2code.sprinboot.cruddemo.entity.Employee;
import com.lu2code.sprinboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Employeerest {

    private EmployeeService employeeService;
@Autowired
    public Employeerest(EmployeeService theempservice){
    employeeService=theempservice;
    }

    @GetMapping("/employees")
    public List<Employee> findall(){
       return employeeService.findAll();
    }

    @GetMapping("/employees/{empid}")
    public Employee getEmpId(@PathVariable int empid){
    Employee themp=employeeService.findbyid(empid);
    if(themp==null)
        throw new RuntimeException("Employee id not found:"+empid);
    return themp;
    }

    @PostMapping("/employees")
    public  Employee addEmployee(@RequestBody Employee theEmployee){


      theEmployee.setId(0);
      Employee theemp=employeeService.save(theEmployee);
      return theemp;
    }

    @PutMapping("/employees/{thempId}")
    public Employee updateEmployee(@RequestBody Employee theemp,@PathVariable int thempId)
    {
        theemp.setId(thempId);
        Employee theemployee=employeeService.save(theemp);
        return theemployee;
    }

    @DeleteMapping("/employees/{theempId}")
    public String delete(@PathVariable int theempId){
    Employee theemp=employeeService.findbyid(theempId);

    if(theemp==null)
        throw new RuntimeException("Employee not found with id "+theempId);
   employeeService.deleteById(theempId);

   return "Deleted the employee by id:"+theempId;
    }



}

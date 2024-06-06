package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {


        private EmployeeService employeeService;

        public EmployeeController(EmployeeService theEmployeeService){
            employeeService=theEmployeeService;
        }

        @GetMapping("/list")
        public String listEmployees(Model themodel){

            List<Employee> list=employeeService.findAll();

            themodel.addAttribute("employees",list);

            return "employees/list-employees";
        }

        @GetMapping("/showFormforadd")
    public String show(Model themodel){
            Employee theEmployee=new Employee();
            themodel.addAttribute("employee",theEmployee);
            return "employees/employee-form";

        }

        @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){
            employeeService.save(theEmployee);

            return "redirect:/employees/list";

        }

        @GetMapping("/showFormforUpdate")
    public String shorForUpdate(@RequestParam("employeeId")int id,Model themodel){
            Employee emp=employeeService.findById(id);

            themodel.addAttribute("employee",emp);
            return "employees/employee-form";}



            @GetMapping("/deleteemp")
            public String delete(@RequestParam("employeeId")int id){
                employeeService.deleteById(id);


                return "redirect:/employees/list";




        }
    }


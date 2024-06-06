package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    @Value("${countries}")
    private List<String> countries;
    @Value("${languages}")
    private List<String> languages;
    @Value("${oses}")
    private List<String> oses;

    @GetMapping("/showStudentForm")
    public String show(Model themodel){
        Student student=new Student();

        themodel.addAttribute("student",student);
        themodel.addAttribute("countries",countries);
        themodel.addAttribute("languages",languages);
        themodel.addAttribute("oses",oses);
        return "student-form";
    }
    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent){
       //System.out.println("Student is "+theStudent.getFirstName()+" "+theStudent.getLastName());
        return "student-confirmation";
    }

}

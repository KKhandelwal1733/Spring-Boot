package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> list;

    @PostConstruct
    public void loadData(){
        list=new ArrayList<>();

        list.add(new Student("poornima","patel"));
        list.add(new Student("pooma","patel"));
        list.add(new Student("poima","patel"));

    }



    @GetMapping("/students")
    public List<Student> getstudents(){


        return list;

    }
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

       if(list.size()<=studentId||studentId<0){
           throw new StudentNotFountException("Student id not found:"+studentId);
       }

        return list.get(studentId);
    }



    }





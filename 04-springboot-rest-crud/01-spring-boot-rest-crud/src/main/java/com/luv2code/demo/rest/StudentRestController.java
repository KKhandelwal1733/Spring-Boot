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

    //add an exception handler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFountException exc){

        StudentErrorResponse error=new StudentErrorResponse();
        error.setStatus((HttpStatus.NOT_FOUND.value()));
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    //adding exception handler for catching any type of exception
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
        StudentErrorResponse error=new StudentErrorResponse();
        error.setStatus((HttpStatus.BAD_REQUEST.value()));
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
    }





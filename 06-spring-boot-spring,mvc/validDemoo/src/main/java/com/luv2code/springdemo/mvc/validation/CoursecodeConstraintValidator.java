package com.luv2code.springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CoursecodeConstraintValidator implements ConstraintValidator<CourseCode,String> {


    private String coursepre;
    @Override
    public void initialize(CourseCode theCourseCode) {
      coursepre=theCourseCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {

        boolean result;
        if(theCode!=null) {
            result = theCode.startsWith(coursepre);
        }
        else
            result=false;

        return result;




    }}


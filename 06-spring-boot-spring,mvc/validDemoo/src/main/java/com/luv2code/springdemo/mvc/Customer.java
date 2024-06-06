package com.luv2code.springdemo.mvc;

import com.luv2code.springdemo.mvc.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {

    private String firstname;

    @NotNull(message = "is required")
    @Size(min =1,message = "is required")
    private String lastname="";
    @NotNull(message = "is required")
    @Min(value = 0,message = "must be greater than or equal to 0")
    @Max(value = 10,message = "must be less than or equal to 10")
    private Integer passes;
    @NotNull(message = "is required")
   @Pattern(regexp = "^[a-zA-Z0-9]{5}",message="only 5 chars/digits")
    private String postalCode;

    @CourseCode(value = "Tops",message = "must start with Tops")
    private String courseCode;
    public Customer(){

    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getPasses() {
        return passes;
    }

    public void setPasses(Integer passes) {
        this.passes = passes;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}

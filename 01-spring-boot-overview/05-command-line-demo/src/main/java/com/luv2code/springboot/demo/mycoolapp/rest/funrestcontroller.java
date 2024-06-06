package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class funrestcontroller {
    @Value("${coach.name}")
    private String coachname;

    @GetMapping("/coach")
    public String getcoach(){
        return coachname;
    }
    @GetMapping("/")
    public String sayhello(){
        return "hello Krishna";
    }

    @GetMapping("/toffee")
    public String givetoffee(){return "take ur red toffee";}

    @GetMapping("/height")
    public String tellheight(){
        return "my height is 5.9";
    }

}


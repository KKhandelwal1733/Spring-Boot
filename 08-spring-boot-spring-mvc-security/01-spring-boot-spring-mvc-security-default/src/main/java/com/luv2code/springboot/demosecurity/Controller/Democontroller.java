package com.luv2code.springboot.demosecurity.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Democontroller {
    @GetMapping("/")
    public String showform(){
        return "home";
    }

    @GetMapping("/leader")
    public String leders(){
        return "leaders";
    }

    @GetMapping("/systems")
    public String system(){
        return "systems";
    }

}

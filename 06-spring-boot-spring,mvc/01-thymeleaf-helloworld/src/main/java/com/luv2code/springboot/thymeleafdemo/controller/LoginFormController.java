package com.luv2code.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginFormController {

    @GetMapping("/showstudent")
    public String show(){
        return "show";
    }
    @GetMapping("/processForm11")
    public String process(@RequestParam("studentName") String name, @RequestParam("studentPass") String pass, Model themodel) {

        if (name.equals("Ravi")&&pass.equals("123")){
            String result="Thank u for logging";
            themodel.addAttribute("value",result);

        }
        else
            themodel.addAttribute("value","U r farzi user");
        return "auth";}



}

package com.luv2code.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloworldController {
    @GetMapping("/showform")
        public String showForm(){
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processform(){
        return "helloworld";
    }

    @RequestMapping("/processFormversion2")
    public String processform2(HttpServletRequest request, Model themodel){
        String name=request.getParameter("studentName");
        name= "YO!"+name.toUpperCase();
        System.out.println("the name is "+name);
        themodel.addAttribute("thedata",name);
        return "helloworld";

 }

    @PostMapping("/processFormversion3")
    public String processform3(@RequestParam("studentName") String name, Model themodel){

        name="Hello!" + name.toUpperCase();

        themodel.addAttribute("thedata",name);
        return "helloworld";


}}

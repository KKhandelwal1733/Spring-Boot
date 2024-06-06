package com.jwt.example.Controller;

import com.jwt.example.Entity.User;
import com.jwt.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeControllers {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<User> getUser(){
        System.out.println("user list is on webpage");
        return userService.getUsers();
    }

    @GetMapping("/curr-user")
    public String getCurrUser(Principal principal){
        return principal.getName();
    }
}

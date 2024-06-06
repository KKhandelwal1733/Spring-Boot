package com.luv2code.springboot.demosecurity.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/show")
    public String showmy(){
        return "fancy-login";
    }

    @GetMapping("/accessdenied")
    public String accessdenied(){
        return "accessdenied";
    }

}

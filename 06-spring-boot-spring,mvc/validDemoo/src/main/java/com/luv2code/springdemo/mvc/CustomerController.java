package com.luv2code.springdemo.mvc;

import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
   @InitBinder
   public void initBinder(WebDataBinder dataBinder){
       StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
       dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
   }


    @GetMapping("/")
    public String showform(Model theModel){
        theModel.addAttribute("customer",new Customer());

        return "customerform";


    }

    @PostMapping("/processForm")
    public String process(@Valid @ModelAttribute("customer") Customer thecustomer, BindingResult theBindingResult){
        //System.out.println("LastName:|"+thecustomer.getLastname());
       // System.out.println("FirstName:|"+thecustomer.getFirstname());
        System.out.println("Binding Result"+theBindingResult.toString());
        System.out.println("\n\n");
        if(theBindingResult.hasErrors()){
            return "customerform";
        }
        else
            return "customer-confirmation";


    }

}

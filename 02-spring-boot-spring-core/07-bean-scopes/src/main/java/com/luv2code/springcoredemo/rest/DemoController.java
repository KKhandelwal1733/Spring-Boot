package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach mycoach;
    private Coach anotherCoach;

    @Autowired
    public DemoController(@Qualifier("tennisCoach") Coach thecoach,@Qualifier("tennisCoach")Coach theAnotherCoach){
        System.out.println("In Constructor:"+getClass().getSimpleName());
        mycoach=thecoach;
        anotherCoach=theAnotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
    return mycoach.getDailyWorkout();}


    @GetMapping("/check")
    public String check(){
        return "Comparing beans: myCaoch==anothercoach, "+(mycoach==anotherCoach);

    }





}

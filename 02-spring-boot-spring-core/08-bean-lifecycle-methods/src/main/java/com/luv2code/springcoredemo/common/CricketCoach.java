package com.luv2code.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println("In Constructor:"+getClass().getSimpleName());
    }


    @PostConstruct
    public void doMyStartupstuff(){
        System.out.println("In doMyStartupstuff:"+getClass().getSimpleName());
    }
    @PreDestroy
    public void doMyCleanupstuff(){
        System.out.println("In doMyCleanstuff:"+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "practice fast bowling for atleast 5 min:)";
    }
}

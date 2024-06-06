package com.luv2code.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {
    private Logger myLogger=Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    private void forControllerPackage(){}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    private void forDAOPackage(){}

    @Pointcut("forControllerPackage()||forServicePackage()||forDAOPackage()")
    private void forAppFlow(){}

    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint){
        String Method=theJoinPoint.getSignature().toShortString();
        myLogger.info("=====> in @Before:calling method:"+Method);
        //

        Object[] args= theJoinPoint.getArgs();
        for (Object temp:args){
            myLogger.info("=====>> argument:"+temp);
        }

    }
    @AfterReturning(pointcut="forAppFlow()",returning="theResult")
    public void afterReturning(JoinPoint joinPoint,Object theResult){
        String Method=joinPoint.getSignature().toShortString();
        myLogger.info("=====> in @AfterReturning:calling method:"+Method);


    myLogger.info("=====>>> result: "+theResult);
    }



}

package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(7)
public class MyCloundLogSynsAspect {
    @Before("com.luv2code.aopdemo.aspect.KKAOPExpressions.forDAOPackageNoGetterSetter()")
    public void logtoCloundSync() {
        System.out.println("\n====>>>Logging cloud in a sync fashion");


    }
}

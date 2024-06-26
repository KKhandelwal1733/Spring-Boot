package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(10)
public class MyAPIAnamytucsAspects {
    @Before("com.luv2code.aopdemo.aspect.KKAOPExpressions.forDAOPackageNoGetterSetter()")
    public void performAPIAnalytics() {
        System.out.println("\n====>>>Performing API Analytics ");
}}

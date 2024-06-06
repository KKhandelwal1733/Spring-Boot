package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    @Pointcut("execution(* com.luv2code.aopdemo.DAO.*.*(..))")
    private void forDAOPackage(){}

    @Pointcut("execution(* com.luv2code.aopdemo.DAO.*.get*(..))")
    private void getter(){}

    @Pointcut("execution(* com.luv2code.aopdemo.DAO.*.set*(..))")
    private void setter(){}

    @Pointcut("forDAOPackage()&&!(getter()||setter())")
    private void forDAOPackageNoGetterSetter(){}

    //@Before("execution(public void add*())")
    @Before("forDAOPackageNoGetterSetter()")
    public void beforeAddAccount(){
        System.out.println("\n====>>>Executing @Before advice addAccount ");


    }
    @Before("forDAOPackageNoGetterSetter()")
    public void performAPIAnalytics() {
        System.out.println("\n====>>>Performing API Analytics ");

    }
    @Before("forDAOPackageNoGetterSetter()")
    public void logtoCloundSync() {
        System.out.println("\n====>>>Logging cloud in a sync fashion");

    }


    }


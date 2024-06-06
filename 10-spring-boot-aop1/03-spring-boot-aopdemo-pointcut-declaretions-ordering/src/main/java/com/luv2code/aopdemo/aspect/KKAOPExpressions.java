package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class KKAOPExpressions {
    @Pointcut("execution(* com.luv2code.aopdemo.DAO.*.*(..))")
   public void forDAOPackage(){}

    @Pointcut("execution(* com.luv2code.aopdemo.DAO.*.get*(..))")
    public void getter(){}

    @Pointcut("execution(* com.luv2code.aopdemo.DAO.*.set*(..))")
    public void setter(){}

    @Pointcut("forDAOPackage()&&!(getter()||setter())")
    public void forDAOPackageNoGetterSetter(){}
}

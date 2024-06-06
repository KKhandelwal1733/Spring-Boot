package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

    @Around("execution( * com.luv2code.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortunate(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
        String method=theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n====>>>Executing @Around om method: "+method);
        long begin=System.currentTimeMillis();
        Object result=null;

        try{
            result=theProceedingJoinPoint.proceed();
            return result;
        }
        catch (Exception exc){
            System.out.println(exc.getMessage());
            //result="Major accident nut no worries.";
            throw exc;
        }
//        long end=System.currentTimeMillis();
//        long duration=end-begin;
//        System.out.println("\n====>Duration is :"+duration);
//
//        return result;
    }
    @After("execution( * com.luv2code.aopdemo.DAO.AccountDAO.findAccounts(..))")
    public void afteadvice(JoinPoint joinPoint){
        String method=joinPoint.getSignature().toShortString();
        System.out.println("\n====>>>Executing @AfterFinally om method: "+method);


    }



    @AfterThrowing(pointcut="execution( * com.luv2code.aopdemo.DAO.AccountDAO.findAccounts(..))",throwing = "theExc")
    public void afterThrowingAdvice(JoinPoint joinPoint,Throwable theExc){
        String method=joinPoint.getSignature().toShortString();
        System.out.println("\n====>>>Executing @AfterThrowing om method: "+method);

        System.out.println("\n =====>>> The Exception is:"+theExc);

    }

    @AfterReturning(pointcut = "execution( * com.luv2code.aopdemo.DAO.AccountDAO.findAccounts(..))",returning = "result")
    public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result){

    String method=theJoinPoint.getSignature().toShortString();
    System.out.println("\n====>>>Executing @AfterReturning om method: "+method);

    System.out.println("\n=====>>result is: "+result);

    

    //post-process the data
    convertAccountsNameToUpperCase(result);
    System.out.println("\n=====>>result is: "+result);}

    private void convertAccountsNameToUpperCase(List<Account> result) {
        for(Account temp:result){
            String name=temp.getName().toUpperCase();
            temp.setName(name);
        }
    }


    //@Before("execution(public void add*())")
    @Before("com.luv2code.aopdemo.aspect.KKAOPExpressions.forDAOPackageNoGetterSetter()")
    public void beforeAddAccount(JoinPoint theJoinPoint) {
        System.out.println("\n====>>>Executing @Before advice addAccount ");

        //display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("METHOD:" + methodSignature);

        //display method arguments

        Object[] args= theJoinPoint.getArgs();

        for(Object temp:args){
            System.out.println(temp);

            if (temp instanceof Account){
                Account theAccount =(Account) temp;
                System.out.println("account name:"+theAccount.getName());
                System.out.println("account level:"+theAccount.getLevel());


            }
        }
    }
    }


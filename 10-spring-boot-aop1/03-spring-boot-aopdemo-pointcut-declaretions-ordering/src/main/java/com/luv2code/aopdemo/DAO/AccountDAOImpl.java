package com.luv2code.aopdemo.DAO;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {
   private String name;
   private String serviceCode;


    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);

    }

    @Override
    public List<Account> findAccounts(boolean tripwire) {
        if(tripwire)
        {
            throw new RuntimeException("No soup for u!!!");
        }
        List<Account> myAccounts=new ArrayList<>();
        Account acc1=new Account("Raju","Silver");
        Account acc2=new Account("Monu","Platinum");
        Account acc3=new Account("Krishna","Diamond");

        myAccounts.add(acc1);
        myAccounts.add(acc2);
        myAccounts.add(acc3);
        return myAccounts;

    }

    @Override
    public void addaccount(Account theAccount,boolean vipFlag) {
        System.out.println(getClass()+":doing my db work: adding an account");

    }

    @Override
    public boolean doWork() {
        System.out.println(getClass()+":doing my db work: do work");
        return false;
    }

    public String getName() {
        System.out.println(getClass()+"in getname");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+"in setname");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass()+"in getServiceCode");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass()+"in setServiceCode");
        this.serviceCode = serviceCode;
    }
}

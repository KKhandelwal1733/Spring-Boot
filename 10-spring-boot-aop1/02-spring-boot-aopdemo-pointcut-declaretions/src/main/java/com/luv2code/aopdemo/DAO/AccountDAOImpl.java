package com.luv2code.aopdemo.DAO;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {
   private String name;
   private String serviceCode;

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

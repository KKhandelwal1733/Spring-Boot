package com.luv2code.aopdemo.DAO;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {


    @Override
    public void addaccount(Account theAccount,boolean vipFlag) {
        System.out.println(getClass()+":doing my db work: adding an account");

    }

    @Override
    public boolean doWork() {
        System.out.println(getClass()+":doing my db work: do work");
        return false;
    }

}

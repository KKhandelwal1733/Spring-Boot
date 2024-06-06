package com.luv2code.aopdemo.DAO;

import com.luv2code.aopdemo.Account;

public interface AccountDAO {
    void addaccount(Account theAccount,boolean vipFlag);

    boolean doWork();



}

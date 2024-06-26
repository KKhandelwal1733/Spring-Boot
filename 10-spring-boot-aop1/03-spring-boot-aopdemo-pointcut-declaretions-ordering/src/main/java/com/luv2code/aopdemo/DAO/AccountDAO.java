package com.luv2code.aopdemo.DAO;

import com.luv2code.aopdemo.Account;

import java.util.List;

public interface AccountDAO {

    List<Account> findAccounts();
    List<Account> findAccounts(boolean tripwire);
    void addaccount(Account theAccount,boolean vipFlag);

    boolean doWork();

    public String getName();

    public void setName(String name) ;

    public String getServiceCode() ;

    public void setServiceCode(String serviceCode) ;



}

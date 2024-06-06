package com.luv2code.aopdemo.DAO;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {


    @Override
    public boolean addMemberaccount() {
        System.out.println(getClass()+":doing my db work: adding an Membership account");
return true;
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass()+":doing my db work: go to sleep");
    }

}

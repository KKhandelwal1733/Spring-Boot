package com.luv2code.aopdemo;

import com.luv2code.aopdemo.DAO.AccountDAO;
import com.luv2code.aopdemo.DAO.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}



@Bean
public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO thememberShipDAO){
	return runner->{
		demothebeforeadvice(theAccountDAO,thememberShipDAO);
	};
}

	private void demothebeforeadvice(AccountDAO theAccountDAO,MembershipDAO theMembershipDAo) {
		Account myAccount =new Account();
		theAccountDAO.addaccount(myAccount,true);
		theAccountDAO.doWork();
       //call the accountable getter/setter methods
		theAccountDAO.setName("Rahul");
		theAccountDAO.setServiceCode("silver");
		String name=theAccountDAO.getName();
		String code=theAccountDAO.getServiceCode();
		theMembershipDAo.addMemberaccount();
		theMembershipDAo.goToSleep();

	}
}


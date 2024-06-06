package com.luv2code.aopdemo;

import com.luv2code.aopdemo.DAO.AccountDAO;
import com.luv2code.aopdemo.DAO.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}



@Bean
public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO thememberShipDAO, TrafficFortuneService trafficFortuneService){
	return runner->{
		//demothebeforeadvice(theAccountDAO,thememberShipDAO);
		//demoTheAfterReturningAdvice(theAccountDAO);
		//demoafterThrowingadvice(theAccountDAO);
		//demoTheAfterAdvice(theAccountDAO);
		//demoTheAroundAdvice(trafficFortuneService );
		//demoTheAroundAdviceHandleException(trafficFortuneService );
		demoTheAroundAdviceHandleRethorwException(trafficFortuneService );
	};
}

	private void demoTheAroundAdviceHandleRethorwException(TrafficFortuneService trafficFortuneService) {
		System.out.println("Main Program :demoTheAroundAdviceHandleRethorwException");
		System.out.println("Calling getFortune()");
		boolean tripwire=true;

		String data=trafficFortuneService.getFortune(tripwire);
		System.out.println("focus is :"+data+"\n\nFinished!!!");
	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {
		System.out.println("Main Program :demotheFortuneservice");
		System.out.println("Calling getFortune()");
		boolean tripwire=true;

		String data=trafficFortuneService.getFortune(tripwire);
		System.out.println("focus is :"+data+"\n\nFinished!!!");
	}

	private void demoTheAroundAdvice(TrafficFortuneService theTrafficFortuneService) {

		System.out.println("Main Program :demotheFortuneservice");
		System.out.println("Calling getFortune()");
		String data=theTrafficFortuneService.getFortune();
		System.out.println("focus is :"+data+"\n\nFinished!!!");
	}

	private void demoTheAfterAdvice(AccountDAO theAccountDAO) {
		List<Account> accounts=null;
		try{
			boolean tripwire =false;
			accounts=theAccountDAO.findAccounts(tripwire);
		}
		catch(Exception exc){
			System.out.println("\n\n Main Program......caught exception....."+exc);
		}
		System.out.println("\n\nMain program: After Throwing");
		System.out.println("-------------");
		System.out.println(accounts);
		System.out.println("\n");

	}

	private void demoafterThrowingadvice(AccountDAO theAccountDAO) {
		List<Account> accounts=null;
		try{
			boolean tripwire =true;
			accounts=theAccountDAO.findAccounts(tripwire);
		}
		catch(Exception exc){
			System.out.println("\n\n Main Program......caught exception....."+exc);
		}
		System.out.println("\n\nMain program: After Throwing");
		System.out.println("-------------");
		System.out.println(accounts);
		System.out.println("\n");

	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {
		List<Account> accounts=theAccountDAO.findAccounts();
		System.out.println("\n\nMain program: After Returning");
		System.out.println("-------------");
		System.out.println(accounts);
		System.out.println("\n");

	}

	private void demothebeforeadvice(AccountDAO theAccountDAO,MembershipDAO theMembershipDAo) {
		Account myAccount =new Account();
		myAccount.setName("Madhu");
		myAccount.setLevel("Platinum");

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


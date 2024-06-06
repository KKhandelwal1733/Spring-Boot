package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner->{
			//createInstructor(appDAO);
			 // findInstructor(appDAO);
			//deleteInstructor(appDAO);
			//findInstructorDetail(appDAO);
			deleteInstructorDetail(appDAO);

		};
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int id=4;
		appDAO.deleteInstructorDetailById(id);
		System.out.println("Instructor detail and associated instructor id deleted of id: "+id);
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int id=2;
		InstructorDetail tem=appDAO.findInstructorDetailById(id);
		System.out.println("Instructor Detail:"+tem);
		System.out.println("the associated instructor: "+tem.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id=1;
		System.out.println("Deleting instructor id: "+id);
		appDAO.deleteInstructorById(id);
		System.out.println("Done!!");

	}

	private void findInstructor(AppDAO appDAO) {
		int id=2;
		System.out.println("Finding instructor id:"+id);
		Instructor temp=appDAO.findInstructorById(id);
		System.out.println("the instructor= " +temp);
		System.out.println("the associate instructorDetails is: "+temp.getInstructorDetail());

	}

	private void createInstructor(AppDAO appDAO){
		/*Instructor temp=new Instructor("Krishna","Khandelwal","kk@gnmail.com");

		InstructorDetail tempdetail=new InstructorDetail("youtbe.hh.com","cricket");

		temp.setInstructorDetail(tempdetail);*/
		Instructor temp=new Instructor("Vishu","Khandelwal","vishu@gmail.com");

		InstructorDetail tempdetail=new InstructorDetail("youtbe.vishu.com","volley");

		temp.setInstructorDetail(tempdetail);

		System.out.println("Saving Instructor: "+temp);
		appDAO.save(temp);
		System.out.println("Done!!");

	}
}

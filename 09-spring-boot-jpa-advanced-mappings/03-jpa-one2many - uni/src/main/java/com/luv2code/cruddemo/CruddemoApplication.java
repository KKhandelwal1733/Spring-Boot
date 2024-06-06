package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import com.luv2code.cruddemo.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner->{
			//createCourseAndReviews(appDAO);
			//retrieveCourseandReviews(appDAO);
			deleteCourseAndReviews(appDAO);




		};
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int id=11;
		appDAO.deleteCourse(id);
		System.out.println("deleted....");
	}

	private void retrieveCourseandReviews(AppDAO appDAO) {

		int id=10;
		Course tempCourse=appDAO.findCourseandReviewsbyId(id);
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
		System.out.println("Done!!!");
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		Course temp=new Course("TiC tac toe");
		temp.addReview(new Review("Great Course..."));
		temp.addReview(new Review("exe Course..."));
		temp.addReview(new Review("4/5..."));
		temp.addReview(new Review("9/10..."));

		System.out.println("Saving the Course....");
		appDAO.save(temp);
		System.out.println(temp);
		System.out.println(temp.getReviews());
		System.out.println("Saved.");


	}

	private void deleteCourseById(AppDAO appDAO) {
		int id=2;
		System.out.println("deleting the couse with id:"+id);
		appDAO.deleteCourse(id);
		System.out.println("Done!!!");

	}

	private void updateCourse(AppDAO appDAO) {
		int id=4;

		Course temp=appDAO.findCourseById(id);
		System.out.println("Updating the instructor");

		temp.setTitle("Basketball Session");
		appDAO.update(temp);
		System.out.println("Donee!!!!!");


	}

	private void updateInstructor(AppDAO appDAO) {
		int id=1;
		System.out.println("Updating the instructor");
		Instructor temp=appDAO.findInstructorById(id);
		temp.setLastname("Saaam");
		appDAO.update(temp);
		System.out.println("Donee!!!!!");
	}

	private void findinstructorwithjoinfetch(AppDAO appDAO) {
		int id=1;
		System.out.println("Finding instructor id:"+id);

		Instructor temp=appDAO.findInstructorByIdJoinFetch(id);
		System.out.println("tempInstructor:"+temp);
		System.out.println("Finding Courses......");
		System.out.println("the associated courses:"+temp.getCourses());
		System.out.println("Done!!!");



	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int id=1;
		System.out.println("Finding instructor id:"+id);
		Instructor temp=appDAO.findInstructorById(id);
		System.out.println("tempInstructor:"+temp);
		System.out.println("Finding Courses......");

	}

	private void findInstructorwithcourses(AppDAO appDAO) {
		int id=1;
		Instructor temp=appDAO.findInstructorById(id);
		System.out.println("tempInstructor:"+temp);
		System.out.println("the associated courses:"+temp.getCourses());
		System.out.println("Done!!!");
	}

	private void createinstructorwithcourses(AppDAO appDAO) {
		Instructor temp=new Instructor("Vishu","Khandelwal","vishu@gmail.com");

		InstructorDetail tempdetail=new InstructorDetail("youtbe.vishu.com","volley");

		temp.setInstructorDetail(tempdetail);

		Course tempcourse1= new Course("Air Guitar-The ultimate guide");
		Course tempcourse2= new Course("Pinball MasterClass");
		Course tempcourse3= new Course("Cricket Session");
		Course tempcourse4= new Course("Football Session");
		//Course tempcourse5= new Course("Air Guitar-The ultimate guide");

		temp.add(tempcourse1);
		temp.add(tempcourse2);
		temp.add(tempcourse3);
		temp.add(tempcourse4);
		//temp.add(tempcourse2);

		System.out.println("Saving instructor"+temp);
		System.out.println("The Courses:"+temp.getCourses());
		appDAO.save(temp);

		System.out.println("Done!!!");



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

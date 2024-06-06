package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner->{
			//createStudent(studentDAO);
			createmulstudent(studentDAO);
			//readStudent(studentDAO);
			//queryforstudentsbylastname(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudents(studentDAO);
			//deleteAllStudnets(studentDAO);
		};
	}

	private void deleteAllStudnets(StudentDAO studentDAO) {
		System.out.println("Deleting all Students");
		int num=studentDAO.deleteAll();
		System.out.println(num+ " rows were deleted.");

	}

	private void deleteStudents(StudentDAO studentDAO) {
		int studentId=3;
		System.out.println("Deleting student id:"+studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		int studentid=1;
		System.out.println("Getting student with id:"+studentid);
		Student thestudent=studentDAO.findVyID(studentid);
		System.out.println("Updating student...");
		thestudent.setFirstName("Dampy");
		studentDAO.update(thestudent);
		System.out.println("Updated Student: "+thestudent);



	}

	private void queryforstudentsbylastname(StudentDAO studentDAO) {
		List<Student> thestudents=studentDAO.bylastname("Dofe");

		for(Student temp:thestudents){
			System.out.println(temp);
		}



	}

	private void queryforStudents(StudentDAO studentDAO) {

		List<Student> theStudent=studentDAO.findAll();

		for(Student temo:theStudent){
			System.out.println(temo);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating new Student:");
		Student temp1=new Student("Paul","Daoe","helwlo@gmail");
		System.out.println("Student created:");
		studentDAO.save(temp1);

		int theid= temp1.getId();
		System.out.println("Retrieving student with Id:"+theid);

		//System.out.println("retrieving student with id:"+theid);
		Student mystudent=studentDAO.findVyID(theid);

		System.out.print("the student is"+mystudent);




	}

	private void createmulstudent(StudentDAO studentDAO){
		System.out.println("Creating new Student:");
		Student temp1=new Student("Paul","Daoe","helwlo@gmail");
		Student temp2=new Student("Pul","Dasoe","helslo@gmail");
		Student temp3=new Student("Pal","Dose","hedllo@gmail");
		Student temp4=new Student("Pauml","Dowe","heldlo@gmail");

		Student temp5=new Student("Paual","Dofe","helddlo@gmail");
		System.out.println("Saving the students");
		studentDAO.save(temp1);
		studentDAO.save(temp2);
		studentDAO.save(temp3);
		studentDAO.save(temp4);
		studentDAO.save(temp5);



	}

	private void createStudent(StudentDAO studentDAO) {

		System.out.println("Creating new Student:");
		Student temp=new Student("Paul","Doe","hello@gmail");
        System.out.println("Saving the student");

		studentDAO.save(temp);
		System.out.println("Saved student id is:"+temp.getId());

	}

}

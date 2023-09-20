package com.jpaapplication.cruddemo;

import com.jpaapplication.cruddemo.dao.StudentDAO;
import com.jpaapplication.cruddemo.entity.Student;
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
		return runner -> {
			//createStudent(studentDAO);
			//createMultipleStudent(studentDAO);
			//readStudent(studentDAO);
			//queryFroStudents(studentDAO);
			//queryforStudentByLastName(studentDAO);
			//updateTheValue(studentDAO);
			//deleteById(studentDAO);
			deleteAll(studentDAO);
		};
	}

	private void deleteAll(StudentDAO studentDAO) {
		int numOfRowDeleted = studentDAO.deleteAll();
		System.out.println("Number of row deleted "+numOfRowDeleted);
	}

	private void deleteById(StudentDAO studentDAO) {
		int id = 3;
		studentDAO.delete(id);
	}

	private void updateTheValue(StudentDAO studentDAO) {
		//retrive student based on the id: primary key
		int id = 1;
		Student students = studentDAO.findById(1);
		System.out.println("before update "+students);
		//set the value to the column
		students.setLastName("Singh");

		//Call update method to update the value
		studentDAO.update(students);
		System.out.println("after update "+students);

	}

	private void queryforStudentByLastName(StudentDAO studentDAO) {
		//Get a list of students
		List<Student> theStudent = studentDAO.findByLastName("Bundela");

		//display the list of students
		theStudent.forEach(student -> System.out.println(student));
	}

	private void queryFroStudents(StudentDAO studentDAO) {
		//Get a list of students
		List<Student> listOfStudents = studentDAO.findAll();

		//display the list of students
		//Using method referencing
		listOfStudents.forEach(System.out::println);
		//Using lamda
	//	listOfStudents.forEach(student -> System.out.println(student));
	}

	private void readStudent(StudentDAO studentDAO) {
		//Create a student object
		Student tempStudent = new Student("Yogi","Bundela","yogi@sucess.com");
		//save the student
		studentDAO.save(tempStudent);
		//display the id of the saved student
		int id = tempStudent.getId();
		System.out.println("saved the student id "+id);
		//retrive student based on the id: primary key
		System.out.println("retrive the student id "+id);
		Student student = studentDAO.findById(id);

		//display student
		System.out.println("found the student "+student);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		// create the multiple student object
		System.out.println("Creating multiple student");
		Student tempStudent = new Student("Priya","Bundela","priya@sucess.com");
		Student tempStudent1 = new Student("Golu","Gupta","golu@gupta.com");
		Student tempStudent2 = new Student("Munna","Raja","Munna@raja.com");

		//save the student object
		System.out.println("Saving multiple student");
		studentDAO.save(tempStudent);
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		Student tempStudent = new Student("Yogi","Bundela","yogi@sucess.com");
		//save the student object
		studentDAO.save(tempStudent);
		//display the saved id

		System.out.println("Saved student id :"+tempStudent.getId());
	}

}

package com.kevin.curd;

import com.kevin.curd.dao.StudentDAO;
import com.kevin.curd.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CurdApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurdApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// System.out.println("Hello world");

			// createStudent(studentDAO);

			// createMultipleStudents(studentDAO);

			// readStudent(studentDAO);

			// queryForStudents(studentDAO);

			// queryForStudentsByLastName(studentDAO);

			updateStudent(studentDAO);
		};
	}

	private void updateStudent(StudentDAO studentDAO) {
		// Retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// Change first name to "Scooby"
		System.out.println("Updating student ...");
		myStudent.setFirstrname("Scooby");

		// Update the student
		studentDAO.update(myStudent);

		// Display the updated student
		System.out.println("Updated student: " + myStudent);




	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("Zhang");

		for (Student temptstudent : theStudents) {
			System.out.println(temptstudent);
		}

	}

	private void queryForStudents(StudentDAO studentDAO) {
		// Get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// Display list of students
		for (Student temptstudent : theStudents) {
			System.out.println(temptstudent);
		}

	}

	private void readStudent(StudentDAO studentDAO) {
		// Create a student object
		System.out.println("Creating a new students object ...");
		Student tempStudent = new Student("Trump", "Duck", "ironman@gmail.com");

		// Save the student
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// Display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		// Retrieve student based on the id: primary key
		System.out.println("Retrieved student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// Display student
		System.out.println("Find the student:  " + myStudent);



	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// Create multiple students
		System.out.println("Creating 3 students object ...");
		Student tempStudent01 = new Student("Kaixin", "Zhang", "kaixin2022mel@gmail.com");
		Student tempStudent02 = new Student("Kevin", "Zhang", "iwantajob@gmail.com");
		Student tempStudent03 = new Student("K", "Zhang", "fullstack@gmail.com");

		// Save the student objects
		System.out.println("Saving the students ...");
		studentDAO.save(tempStudent01);
		studentDAO.save(tempStudent02);
		studentDAO.save(tempStudent03);

	}

	private void createStudent(StudentDAO studentDAO) {
		// Create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Kaixin", "Zhang", "kaixin2022mel@gmail.com");

		// Save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// Display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());

	}

}

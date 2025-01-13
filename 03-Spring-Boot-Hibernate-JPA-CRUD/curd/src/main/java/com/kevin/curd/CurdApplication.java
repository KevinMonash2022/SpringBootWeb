package com.kevin.curd;

import com.kevin.curd.dao.StudentDAO;
import com.kevin.curd.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CurdApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurdApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			System.out.println("Hello world");
			createStudent(studentDAO);
		};
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

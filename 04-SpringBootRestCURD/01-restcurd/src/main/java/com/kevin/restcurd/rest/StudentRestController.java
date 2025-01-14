package com.kevin.restcurd.rest;

import com.kevin.restcurd.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    // Define @PostConstruct to load the student data ... only once !
    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Rino", "Patel"));
        theStudents.add(new Student("Ash", "Rossi"));
        theStudents.add(new Student("Vox", "Jackson"));
    }


    // Define end point for "/students" - return a list of students

    @GetMapping("/students")
    public List<Student> getStudents() {

        return theStudents;
    }


    // Define endpoint or "/students/{studentId}" - return student at index

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        // Just index into the list ... keep it simple for now

        // Check the studentId again list size

        if ((studentId >= theStudents.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return theStudents.get(studentId);

    }

    // Add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {

        // Create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // Return response

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // Add another exception handler to catch all the errors

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handlerException(Exception exc) {
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // Return response

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }



}

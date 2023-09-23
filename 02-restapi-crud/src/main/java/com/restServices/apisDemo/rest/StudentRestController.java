package com.restServices.apisDemo.rest;

import com.restServices.apisDemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    @PostConstruct
    public void loadStudents(){
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Yogi","Bundela"));
        theStudents.add(new Student("priya","Bundela"));
        theStudents.add(new Student("Roopa","patel"));
    }
    //define endpoint for /student, which return list of all student
    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }

   //define endpoint /student/{studentId}. return single student at particular index.
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        return theStudents.get(studentId);
    }
}

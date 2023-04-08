package com.example.demo;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication  {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

@Autowired
    private StudentRepository studentRepository;

    public  void  run(String...a) {
//        Student student = new Student("jack", "mike", "@jack.gmail.com");
//
//        studentRepository.save(student);
//
//          Student student1 = new Student("jack", "mike", "@jack.gmail.com");
//
//        studentRepository.save(student1);


    }
}

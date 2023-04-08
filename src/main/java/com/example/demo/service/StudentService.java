package com.example.demo.service;

import com.example.demo.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudent();

    Student saveStudent(Student student);

    Student getStudentById(Long studentId);

    Student updateStudent(Student student,Long ID);

    void deleteStudent(Long id);
}

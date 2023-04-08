package com.example.demo.service.implementation;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Service
public class StudentServiceImp implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudent() {
        return  studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long studentId) {
        return     studentRepository.findById(studentId).get();
    }

    @Override
    public Student updateStudent(Student student, Long Id) {
        Student  student1 = studentRepository.findById(Id).get();

        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setEmail(student.getEmail());
        return studentRepository.save(student1);
    }

    @Override
    public void deleteStudent(@PathVariable("id") Long id ) {
        studentRepository.deleteById(id);
    }
}

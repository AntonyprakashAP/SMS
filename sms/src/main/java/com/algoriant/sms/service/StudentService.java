package com.algoriant.sms.service;

import com.algoriant.sms.entity.Student;
import com.algoriant.sms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    Student student = new Student();

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student modifyStudent(Student student) {
        Optional<Student> student1 = studentRepository.findById(student.getId());
        if(student1.isPresent()) {
            Student student2 = student1.get();
            student2.setId(student.getId());
            student2.setName(student.getName());
            student2.setEmail(student.getEmail());
            student2.setPhoneno(student.getPhoneno());
            studentRepository.save(student2);
        }
        return student;
    }
    public void removeStudent(int id) {
        studentRepository.deleteById(id);
    }

    public Student getStudent(int id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return student.get();
        }
        return null;
    }
    public List<Student> getAllStudent() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }
}

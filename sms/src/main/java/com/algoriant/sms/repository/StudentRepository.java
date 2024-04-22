package com.algoriant.sms.repository;

import com.algoriant.sms.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {

    Student findByEmail(String email);
}

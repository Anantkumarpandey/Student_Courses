package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;

public interface StudentRepository {

	List<Student> findAll();

	Object findById(int id);

	Student save(Student student);

}

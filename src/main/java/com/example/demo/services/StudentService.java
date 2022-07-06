package com.example.demo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {

	
	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> findAll()
	{
		return studentRepository.findAll();
	}
	
	public Student findById(int id)
	{
		return studentRepository.findById(id).get();
	}
	
	@Transactional
	public Student save(Student student)
	{
		return studentRepository.save(student);
	}
	
	
}

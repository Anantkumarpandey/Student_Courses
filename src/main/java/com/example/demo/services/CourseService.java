package com.example.demo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	
	private CourseRepository courseRepository;
	
	public List<Course>findAll()
	{
		return courseRepository.findAll();
	}
	
	public Course findById(int id)
	{
		return courseRepository.findById(id).get();
	}
	
	@Transactional
	public Course save(Course course)
	{
		return courseRepository.save(course);
	}

}

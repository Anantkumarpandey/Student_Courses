package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.services.CourseService;
import com.example.demo.services.StudentService;

@SpringBootApplication
public class StudentCoursesApplication {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private CourseService courseService;

	public static void main(String[] args) {
		SpringApplication.run(StudentCoursesApplication.class, args);
	}
	
	
	public void run(String... args) throws Exception 
	{
		Student student = new Student("Aditya");
		studentService.save(student);
		Course course = new Course("Spring Boot");
		courseService.save(course);
		student.addCourse(course);
		studentService.save(student);
		course.addStudent(student);
		courseService.save(course);
	}


}

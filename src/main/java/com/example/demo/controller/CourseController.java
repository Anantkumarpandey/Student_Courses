package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Course;
import com.example.demo.entity.Review;
import com.example.demo.services.CourseService;

@Controller
@RequestMapping
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("")
	public String findAll(Model model)
	{
		List<Course> course =courseService.findAll();
		model.addAttribute("course",course);
		return "course-list";
	}
	
	@GetMapping("/{id}")
	public String findById(@PathVariable("id") int id,Model model)
	{
		Course course =courseService.findById(id);
		model.addAttribute("course",course);
		List<Review> review = course.getReview();
		model.addAttribute("review", review);
		return "course-details";
	}
	
	
	
	

}

package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Course;
import com.example.demo.entity.Review;
import com.example.demo.entity.Roll;
import com.example.demo.entity.Student;
import com.example.demo.services.CourseService;
import com.example.demo.services.ReviewService;
import com.example.demo.services.RollService;
import com.example.demo.services.StudentService;



@Controller
@RequestMapping("/review")
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/add")
	public String add(Model model, @RequestParam("id") int id)
	{
		Review theReview = new Review();
		model.addAttribute("theReview", theReview);
		model.addAttribute("id", id);
		return "review-form";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("theReview") Review theReview, @RequestParam("id") int id)
	{
		Course course = courseService.findById(id);
		theReview.setCourse(course);
		reviewService.save(theReview);
		course.addReview(theReview);
		courseService.save(course);
		return "redirect:/courses/"+id;
	}
	
	@GetMapping("/remove")
	public String remove(@RequestParam("id") int id, @RequestParam("cid") int cid)
	{
		Course course = courseService.findById(cid);
		Review review = reviewService.findById(id);
		course.removeReview(review);
		courseService.save(course);
		reviewService.remove(review);
		return "redirect:/courses/"+cid;
	}

}

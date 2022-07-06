package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Roll;
import com.example.demo.entity.Student;
import com.example.demo.services.RollService;
import com.example.demo.services.StudentService;


@Controller
@RequestMapping("/roll")
public class RollController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private RollService passportService;
	
	@GetMapping("/add")
	public String add(Model model, @RequestParam("id") int id)
	{
		Roll theRoll = new Roll();
		model.addAttribute("thePassport", theRoll);
		model.addAttribute("id", id);
		return "passport-form";
	}
	
	@PostMapping("/save")
	public String save(@RequestParam("id") int id, @ModelAttribute("theRoll") Roll theRoll)
	{
		Student student = studentService.findById(id);
		theRoll.setStudent(student);
		passportService.save(theRoll);
		student.setRoll(theRoll);
		studentService.save(student);
		return "redirect:/students";
	}

}

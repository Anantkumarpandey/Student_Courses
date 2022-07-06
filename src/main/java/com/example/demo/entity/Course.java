package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Course {
	@Id
	@GeneratedValue
	private int id;
	
	@Column(unique=true)
	private String name;
	
	@OneToMany(mappedBy = "course")
	@JsonIgnore
	private List<Review>review =new ArrayList<>();
	
	@ManyToMany(mappedBy = "course")
	@JsonIgnore
	private List<Student>student =new ArrayList<>();
	
	public Course()
	{
		
	}
	
	public Course(String name)
	{
		this.name=name;
		
	}
	
	public String getName()
	{
		return name;
		
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	
	public int  getId()
	{
		return id;
		
	}
	
	public List<Review> getReview()
	{
		return review;
	}
	
	public void addReview(Review review)
	{
		this.review.add(review);
	}
	
	public void removeReview(Review review)
	{
		this.review.remove(review);
	}
	
	public List<Student> getStudent()
	{
		return student;
	}
	
	public void addStudent (Student student)
	{
		this.student.add(student);
	}
	
	public void removeStudent (Student student)
	{
		this.student.remove(student);
	}
	
	@Override
	public String toString()
	{
		return "Course[id="+id+",name="+name+"]";
	}
	

}

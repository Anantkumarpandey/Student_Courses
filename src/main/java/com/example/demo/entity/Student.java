package com.example.demo.entity;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Student {
	@Id
	@GeneratedValue
	private int id ;
	
	@Column
	private String name ;
	
	@OneToOne
	private Roll roll;
	
	@ManyToMany
	@JoinTable(name="Student_Course",joinColumns = @JoinColumn(name="Student_ID"),inverseJoinColumns=@JoinColumn(name="COURSE_ID"))
	private List<Course> course=new ArrayList<>();
	
	public Student()
	{
		
	}
	
	public Student(String name)
	{
		this.name=name;
	}
	
	public int getId()
	{
		return id;
		
	}
	
	public String getName()
	{
		return name;
		
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public Roll grtRoll()
	{
		return roll;
	}
	
	public void setRoll(Roll roll) {
		this.roll=roll;
	}
	
	public List<Course> getCourse()
	{
		return course;
	}
	 
	public void addCourse(Course course)
	{
		this.course.add(course);
	}
	
	public void removeCourse(Course course)
	{
		this.course.remove(course);
	}
	
	public void setId(int id)
	{
		this.id=id;
	}
	
	public void setCourse(List<Course>course)
	{
		this.course=course;
	}
	
	@Override
	public String toString()
	{
		return "Student[id="+id+",name="+name+"]";
	}
		
	}
	



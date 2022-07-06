package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Review {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(nullable = false)
	private String rating;
	
	
	@Column(nullable = false)
	private String description;
	
	@ManyToOne
	private Course course;
	
	public Review()
	{
		
	}
	
	public Review(String rating,String description)
	{
		this.rating=rating;
		this.description=description;
	}
	
	public int getId() {
		return id;
	}
	
	public String getRating()
	{
		return rating;
	}
	
	public void setRating(String rating)
	{
		this.rating=rating;
	}
	
	
	public String getDescription()
	{
		return description;
	}
	
	public void setDescription(String rating)
	{
		this.description=description;
	}
	
	public Course getCourse()
	{
		return course;
	}
	
	public void setCourse(Course course2)
	{
		this.course=this.course;
	}
	
	@Override
	public String toString()
	{
		return "Review[id="+id+",rating="+rating+",decsription="+description+",course="+course+"]";
	}
	

}

package com.example.demo.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Review;
import com.example.demo.repository.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;
	
	public Review findById(int id)
	{
		return reviewRepository.findById(id).get();
	}
	
	@Transactional
	public Review save(Review review)
	{
		return reviewRepository.save(review);
	}
	
	@Transactional
	public void remove(Review review)
	{
		reviewRepository.delete(review);
	}
	
	
}

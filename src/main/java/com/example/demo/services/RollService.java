package com.example.demo.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Roll;
import com.example.demo.repository.RollRepository;

@Service
public class RollService {
	
	@Autowired
	private RollRepository rollRepository;
	
	@Transactional
	public Roll save(Roll roll)
	{
		return rollRepository.save(roll);
	}

}

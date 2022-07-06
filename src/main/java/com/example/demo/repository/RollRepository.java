package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Course;
import com.example.demo.entity.Roll;

public interface RollRepository extends JpaRepository<Roll, Integer> {

}

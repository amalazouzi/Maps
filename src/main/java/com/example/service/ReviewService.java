package com.example.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Review;
import com.example.model.User;

public interface ReviewService extends JpaRepository <Review, Integer> {
	
	List<Review> findByUser(User user);
	




}



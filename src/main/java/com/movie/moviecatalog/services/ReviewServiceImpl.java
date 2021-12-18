package com.movie.moviecatalog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.moviecatalog.dao.ReviewRepository;
import com.movie.moviecatalog.model.ReviewModel;

@Service
public class ReviewServiceImpl implements ReviewService {
 
	@Autowired
	ReviewRepository reviewRepo;
	
	@Override
	public ReviewModel addComments(ReviewModel review) {
		return reviewRepo.save(review);
	}

}

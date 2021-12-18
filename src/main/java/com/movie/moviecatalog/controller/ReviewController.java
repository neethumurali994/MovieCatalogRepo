package com.movie.moviecatalog.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.movie.moviecatalog.model.ReviewModel;
import com.movie.moviecatalog.services.MovieService;
import com.movie.moviecatalog.services.ReviewService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class ReviewController {

	@Autowired
	ReviewService reviewService;

	@Autowired
	MovieService movieService;

	/* add reviews and rating */
	@PostMapping("/movie/{movieid}/reviews")
	public Optional<ReviewModel> createComment(@PathVariable(value = "movieid") int movieid,
			@RequestBody ReviewModel comment) {
		return movieService.findMovieById(movieid).map(movie -> {
			comment.setMovie(movie);
			return reviewService.addComments(comment);
		});
	}

}

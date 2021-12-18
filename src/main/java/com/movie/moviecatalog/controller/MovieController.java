package com.movie.moviecatalog.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.moviecatalog.model.MovieModel;
import com.movie.moviecatalog.services.MovieService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	/* get all movies*/
	@GetMapping("/getallmovies")
	public ResponseEntity<List<MovieModel>> getAllMovies() {
		List<MovieModel> movies = new ArrayList<MovieModel>();
		movieService.findAllMovies().forEach(movies::add);
		if (movies.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(movies, HttpStatus.OK);
	}

	/*get a movie by ID*/
	@GetMapping("/getamovie/{id}")
	public ResponseEntity<MovieModel> getMovieById(@PathVariable("id") int id) {
		Optional<MovieModel> moviedata = movieService.findMovieById(id);

		if (moviedata.isPresent()) {
			return new ResponseEntity<>(moviedata.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/*add a movie*/
	@PostMapping("/addmovie")
	public ResponseEntity<MovieModel> addMovie(@RequestBody MovieModel movie) {
		try {
			MovieModel amovie = movieService.addMovie(new MovieModel(movie.getName(), movie.getLanguage(),
					movie.getRelaseDate(), movie.getGenre(), movie.getDirector(), movie.getActor()));
			return new ResponseEntity<>(amovie, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*update movie*/
	@PutMapping("/updatemovie/{id}")
	public ResponseEntity<MovieModel> updateMovie(@PathVariable("id") int id, @RequestBody MovieModel movie) {
		Optional<MovieModel> movieData = movieService.findMovieById(id);

		if (movieData.isPresent()) {
			MovieModel _movieData = movieData.get();
			_movieData.setName(movie.getName());
			_movieData.setActor(movie.getActor());
			_movieData.setDirector(movie.getDirector());
			_movieData.setGenre(movie.getGenre());
			_movieData.setLanguage(movie.getLanguage());
			_movieData.setRelaseDate(movie.getRelaseDate());
			return new ResponseEntity<>(movieService.addMovie(_movieData), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/*delete a movie*/
	@DeleteMapping("/deletemovie/{id}")
	public ResponseEntity<HttpStatus> deleteMovie(@PathVariable("id") int id) {
		try {
			int num = movieService.deleteMovieById(id);
			if (num > 0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return null;

	}

	/*delete all movies*/
	@DeleteMapping("/deletemovies")
	public ResponseEntity<HttpStatus> deleteAllTutorials() {

		try {
			int num = movieService.deleteAllMovies();
			if (num > 0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return null;
	}

	/*add movies*/
	@PostMapping("/addallmovies")
	public ResponseEntity<List<MovieModel>> addAllMovies(@RequestBody List<MovieModel> movies) {
		try {
			List<MovieModel> allmovies = movieService.saveAllMovies(movies);
			return new ResponseEntity<>(allmovies, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*get movie by search criteria name and genre*/
	@GetMapping("/getamoviebycriteria")
	public ResponseEntity<MovieModel> getMovieByNameAndGenre(@RequestBody Map<String, String> param) {
		String name = param.get("name");
		String genre = param.get("genre");
		Optional<MovieModel> movie = movieService.searchByNameandGenre(name, genre);

		if (movie.isPresent()) {
			return new ResponseEntity<>(movie.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}

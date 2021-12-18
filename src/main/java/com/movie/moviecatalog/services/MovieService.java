package com.movie.moviecatalog.services;

import java.util.List;
import java.util.Optional;

import com.movie.moviecatalog.model.MovieModel;

public interface MovieService {
	
 List<MovieModel> findAllMovies();
 
 MovieModel addMovie(MovieModel movie);
 
 Optional<MovieModel> findMovieById(int id);
 
 MovieModel updateMovie(MovieModel movie);
 
 int deleteMovieById(int id);
 
 int deleteAllMovies();
 
 List<MovieModel> saveAllMovies(List<MovieModel> movieList);
 
 Optional<MovieModel> searchByNameandGenre(String name,String genre); 
}

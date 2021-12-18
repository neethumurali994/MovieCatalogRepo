package com.movie.moviecatalog.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.moviecatalog.dao.MovieRepository;
import com.movie.moviecatalog.model.MovieModel;

@Service
public class MovieServiceImpl implements MovieService {
    
	@Autowired
	private MovieRepository movieRepo;
	
	@Override
	public List<MovieModel> findAllMovies() {
		// TODO Auto-generated method stub
		 return movieRepo.findAll();
	}

	@Override
	public MovieModel addMovie(MovieModel movie) {
		// TODO Auto-generated method stub
		return movieRepo.save(movie);
	}


	@Override
	public MovieModel updateMovie(MovieModel movie) {
		// TODO Auto-generated method stub
		return movieRepo.save(movie);
	}


	@Override
	public int deleteMovieById(int id) {
		// TODO Auto-generated method stub
		try {
            movieRepo.deleteById(id);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
	}

	@Override
	public Optional<MovieModel> findMovieById(int id) {
		// TODO Auto-generated method stub
		return movieRepo.findById(id);
	}

	@Override
	public int deleteAllMovies() {
		// TODO Auto-generated method stub
		try {
			movieRepo.deleteAll();
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
		
	}

	@Override
	public List<MovieModel> saveAllMovies(List<MovieModel> movieList) {
		// TODO Auto-generated method stub
		return movieRepo.saveAll(movieList);
	}

	@Override
	public Optional<MovieModel> searchByNameandGenre(String name, String genre) {
		// TODO Auto-generated method stub
		return movieRepo.searchByNameAndGenre(name, genre);
	}

}

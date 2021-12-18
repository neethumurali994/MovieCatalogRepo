package com.movie.moviecatalog.dao;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.movie.moviecatalog.model.MovieModel;

@Repository
public interface MovieRepository extends JpaRepository<MovieModel, Integer> {
  
	@Query(value ="select movie_Id,name,relase_Date,language,genre,director,actor from movie where lower(name) like lower(concat('%',?1,'%')) and lower(genre) like lower(concat('%',?2,'%'))",nativeQuery = true)
	public Optional<MovieModel> searchByNameAndGenre(String name,String genre);
}

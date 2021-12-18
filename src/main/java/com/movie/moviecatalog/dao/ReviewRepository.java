package com.movie.moviecatalog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.moviecatalog.model.ReviewModel;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewModel, Integer> {

}

package com.movie.moviecatalog.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "review")
public class ReviewModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int reviewId;
	
	private String reviewerName;
	
	private String comments;
	
	private Date reviewDate;
	
	private float rating;
	

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "movieId",referencedColumnName = "movieId")
    private MovieModel movie;
	
	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public String getReviewerName() {
		return reviewerName;
	}

	public void setReviewerName(String reviewerName) {
		this.reviewerName = reviewerName;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	
	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public MovieModel getMovie() {
		return movie;
	}

	public void setMovie(MovieModel movie) {
		this.movie = movie;
	}

	public ReviewModel(int reviewId, String reviewerName, String comments, Date rdate, float rating,MovieModel movie) {
		super();
		this.reviewId = reviewId;
		this.reviewerName = reviewerName;
		this.comments = comments;
		this.reviewDate = rdate;
		this.rating = rating;
		this.movie = movie;
	}
	public ReviewModel()
	{}

	@Override
	public String toString() {
		return "ReviewModel [reviewId=" + reviewId + ", reviewerName=" + reviewerName + ", comments=" + comments
				+ ", reviewDate=" + reviewDate + ", rating=" + rating + ", movie=" + movie + "]";
	}

	
	
	
}

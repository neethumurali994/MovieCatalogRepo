package com.movie.moviecatalog.model;


import java.util.Date;



import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;



@Entity
@Table(name = "movie")
public class MovieModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int movieId;
	
	private String name;
	
	private String language;
	
	private Date relaseDate;
	
	private String genre;
	
	private String director;
	
	private String actor;
    
	/*@OneToMany(fetch = FetchType.EAGER,mappedBy = "movie",cascade = CascadeType.ALL)
	@JsonIgnoreProperties("movie")
	private List<ReviewModel> reviews = new ArrayList<ReviewModel>();*/
	
	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Date getRelaseDate() {
		return relaseDate;
	}

	public void setRelaseDate(Date relaseDate) {
		this.relaseDate = relaseDate;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}


/*	public List<ReviewModel> getReviews() {
		return reviews;
	}

	public void setReviews(List<ReviewModel> reviews) {
		this.reviews = reviews;
	}
*/
	public MovieModel( String name, String language, Date relaseDate, String genre, String director,
			String actor) {
		super();
		
		this.name = name;
		this.language = language;
		this.relaseDate = relaseDate;
		this.genre = genre;
		this.director = director;
		this.actor = actor;
	}
	public MovieModel()
	{
		
	}

	@Override
	public String toString() {
		return "MovieModel [movieId=" + movieId + ", name=" + name + ", language=" + language + ", relaseDate="
				+ relaseDate + ", genre=" + genre + ", director=" + director + ", actor=" + actor + "]";
	}
	
}

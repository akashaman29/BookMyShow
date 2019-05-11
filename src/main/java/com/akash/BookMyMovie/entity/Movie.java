package com.akash.BookMyMovie.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="movie_details")
public class Movie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer movie_id;
	
	private String movie_name;
	private Integer movie_price;
	
	
	public Movie() {
	}

	public Movie(Integer movie_id, String movie_name, Integer movie_price) {
		super();
		this.movie_id = movie_id;
		this.movie_name = movie_name;
		this.movie_price = movie_price;
	}

	public Integer getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(Integer movie_id) {
		this.movie_id = movie_id;
	}

	public String getMovie_name() {
		return movie_name;
	}

	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}

	public Integer getMovie_price() {
		return movie_price;
	}

	public void setMovie_price(Integer movie_price) {
		this.movie_price = movie_price;
	}

	@Override
	public String toString() {
		return "Movie [movie_id=" + movie_id + ", movie_name=" + movie_name + ", movie_price=" + movie_price + "]";
	}
	
	
}

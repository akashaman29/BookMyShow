package com.akash.BookMyMovie.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="available_movie")
public class AvailableMovie {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String movie;
	private Integer availability;
	
	public AvailableMovie() {
	}
	
	public AvailableMovie(int id, String movie, Integer availability) {
		super();
		this.id = id;
		this.movie = movie;
		this.availability = availability;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMovie() {
		return movie;
	}
	public void setMovie(String movie) {
		this.movie = movie;
	}
	public Integer getAvailability() {
		return availability;
	}
	public void setAvailability(Integer availability) {
		this.availability = availability;
	}
	@Override
	public String toString() {
		return "AvailableMovie [id=" + id + ", movie=" + movie + ", availability=" + availability + "]";
	}
	
	

}

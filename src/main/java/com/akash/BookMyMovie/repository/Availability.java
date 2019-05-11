package com.akash.BookMyMovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akash.BookMyMovie.entity.AvailableMovie;

public interface Availability extends JpaRepository<AvailableMovie, Integer> {
	
	public AvailableMovie getByMovie(String movie);

}

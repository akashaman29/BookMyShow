package com.akash.BookMyMovie.service;

import java.util.List;

import com.akash.BookMyMovie.dto.CustomerDTO;
import com.akash.BookMyMovie.entity.AvailableMovie;
import com.akash.BookMyMovie.entity.Movie;

public interface MovieService {

	String registerUser(CustomerDTO customerDTO);

	List<Movie> getAllMovies();

	AvailableMovie getAvailableTickets(String moviename);

	String purchaseMovie(String movie_name, Integer ticket_Count);

	String buyMovieTickets(Integer amount, String movie_name,String user_name);

}

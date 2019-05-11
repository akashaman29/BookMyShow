package com.akash.BookMyMovie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.akash.BookMyMovie.dto.CustomerDTO;
import com.akash.BookMyMovie.entity.AvailableMovie;
import com.akash.BookMyMovie.entity.Movie;
import com.akash.BookMyMovie.service.MovieService;

@RestController
@RequestMapping
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	
	@PostMapping("/registerUser")
	public ResponseEntity<String> registerUser(@RequestBody CustomerDTO customerDTO){
		String msg = movieService.registerUser(customerDTO);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@GetMapping("/getMovies")
	public List<Movie> getAllMovie(){
		return movieService.getAllMovies(); 
	}
	
	@PostMapping("/availableTickets")
	public AvailableMovie availableTickets(@RequestParam("Movie Name") String moviename) {
		return movieService.getAvailableTickets(moviename);
	}

	@PostMapping("/checkAvaibilityOfTicket")
	public ResponseEntity<String> availableMovie(@RequestParam("Movie Name")String movie_name,
			@RequestParam("No. of Tickets")Integer Ticket_Count){
		String msg = movieService.purchaseMovie(movie_name,Ticket_Count);
		return new ResponseEntity<String>(msg,HttpStatus.OK); 
	}
	
	@PostMapping("/purchaseMovie")
	public ResponseEntity<String> buyMovieTickets(@RequestParam("Paid Amount")Integer amount
			,@RequestParam("Movie Name")String movie_name,@RequestParam("User Name") String user_name){
		String msg = movieService.buyMovieTickets(amount,movie_name,user_name);
		return new ResponseEntity<String>(msg,HttpStatus.OK);		
	}
	
	@GetMapping("/getMovieDetails")
	public List<Movie> getMovieDetails(){
		return movieService.getAllMovies();
	}
}

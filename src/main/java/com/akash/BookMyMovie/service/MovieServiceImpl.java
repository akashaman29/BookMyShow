package com.akash.BookMyMovie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akash.BookMyMovie.dto.CustomerDTO;
import com.akash.BookMyMovie.entity.Address;
import com.akash.BookMyMovie.entity.AvailableMovie;
import com.akash.BookMyMovie.entity.Customer;
import com.akash.BookMyMovie.entity.Movie;
import com.akash.BookMyMovie.entity.TicketDetails;
import com.akash.BookMyMovie.repository.AddressRepository;
import com.akash.BookMyMovie.repository.Availability;
import com.akash.BookMyMovie.repository.CustomerRepository;
import com.akash.BookMyMovie.repository.MovieRepository;
import com.akash.BookMyMovie.repository.TicketBookedRepository;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	Availability availability;
	
	@Autowired
	TicketBookedRepository ticketBookedRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Override
	public String registerUser(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		customer.setUser_name(customerDTO.getUser_name());
		customer.setPassword(customerDTO.getPassword());
		customer.setConfirm_password(customerDTO.getConfirm_password());
		customer.setCustomer_name(customerDTO.getCustomer_name());
		if(!customerDTO.getPassword().equals(customerDTO.getConfirm_password()))
			  return "Password did not match";
		else if(customer!=null  ) {
			customerRepository.save(customer);
			return "User "+customer.getUser_name()+ " hasbeen registered successfully";
		} 
		else 
			return "Something went wrong";
		
	}

	@Override
	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	@Override
	public AvailableMovie getAvailableTickets(String moviename) {
		return availability.getByMovie(moviename);	 
	}

	@Override
	public String purchaseMovie(String movie_name, Integer ticket_Count) {
		Movie movie = new Movie();
		Integer totalAmount = null;
		AvailableMovie availableMovie = new AvailableMovie();
		availableMovie = availability.getByMovie(movie_name);
		if(availableMovie.getAvailability()>=ticket_Count) {
			movie = movieRepository.getByMovie_name(movie_name);
			totalAmount = ticket_Count * movie.getMovie_price();
			return "You have to pay "+ totalAmount + " for "+movie.getMovie_name();
		}
		else
		    return "Not enough amount to purchase";
	}

	@Override
	public String buyMovieTickets(Integer amount, String movie_name,String user_name) {
		try {
		TicketDetails ticketDetails = new TicketDetails();
		Movie movie = new Movie();
		Customer customer = new Customer();
		AvailableMovie availableMovie = new AvailableMovie();
		customer = customerRepository.getByUser_name(user_name);
		movie = movieRepository.getByMovie_name(movie_name);
		ticketDetails.setAmountpaid(amount);
		ticketDetails.setMovie_name(movie_name);
		ticketDetails.setNooftickets(amount / movie.getMovie_price());
		ticketDetails.setUsername(customer.getUser_name());
		ticketBookedRepository.save(ticketDetails);
		availableMovie = availability.getByMovie(movie_name);
		availableMovie.setAvailability(availableMovie.getAvailability() 
				- amount / movie.getMovie_price());
		availability.save(availableMovie);
		return "User "+ customer.getUser_name()+" has successfully purchased "+ticketDetails
				.getNooftickets()+ " of movie "+ticketDetails.getMovie_name() ;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return "Something went wrong";
	}

	public String addingNewAddress(String user_name, Address address) {
        Customer customer = new Customer();
        customer.setCustomer_name(user_name);
        customer = customerRepository.getByUser_name(user_name);
        address.setCustomer(customer);
        addressRepository.save(address);
		return "User "+user_name+" "+address.getCity_name()+ "has been saved successfully";
	}

}

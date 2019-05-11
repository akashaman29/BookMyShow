package com.akash.BookMyMovie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.akash.BookMyMovie.entity.Address;
import com.akash.BookMyMovie.service.MovieService;

@RestController
public class UserController {
	
	@Autowired
	MovieService movieService;

	@PostMapping("/addingaddress")
	public ResponseEntity<String> addingaddress(@RequestParam("User Name") String user_name,
			@RequestBody Address address){
		  String message = movieService.addingNewAddress(user_name,address);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
}

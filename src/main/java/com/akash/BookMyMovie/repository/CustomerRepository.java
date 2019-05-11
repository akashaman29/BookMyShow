package com.akash.BookMyMovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.akash.BookMyMovie.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	@Query(value="select * from Customer_details where user_name=?1",nativeQuery=true)
	Customer getByUser_name(String user_name);

}

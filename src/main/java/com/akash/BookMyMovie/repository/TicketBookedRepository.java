package com.akash.BookMyMovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akash.BookMyMovie.entity.TicketDetails;

@Repository
public interface TicketBookedRepository extends JpaRepository<TicketDetails, Integer> {

}

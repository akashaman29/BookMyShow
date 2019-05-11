package com.akash.BookMyMovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akash.BookMyMovie.entity.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat,Integer> {

}

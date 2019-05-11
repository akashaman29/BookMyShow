package com.akash.BookMyMovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.akash.BookMyMovie.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {
	
	@Query(value="select * from movie_details where movie_name=?1",nativeQuery=true)
	public Movie getByMovie_name(String movie_name);

}

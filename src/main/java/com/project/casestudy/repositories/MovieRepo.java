package com.project.casestudy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.casestudy.entities.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long> {
	
	List<Movie> findByMovieName(String name);
}

package com.project.casestudy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.casestudy.entities.Theatre;

@Repository
public interface TheatreRepo extends JpaRepository<Theatre, Long> {
	
	
	

}

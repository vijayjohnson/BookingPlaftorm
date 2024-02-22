package com.project.casestudy.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.casestudy.entities.Shows;

@Repository
public interface ShowRepo extends JpaRepository<Shows, Long>{
	
	
	//List<Shows> findByToDateLessThan(LocalDate date);

}

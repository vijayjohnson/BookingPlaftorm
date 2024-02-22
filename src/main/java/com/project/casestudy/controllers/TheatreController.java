package com.project.casestudy.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.casestudy.entities.Movie;
import com.project.casestudy.entities.Theatre;
import com.project.casestudy.repositories.TheatreRepo;
import com.project.casestudy.services.TheatreService;

@RestController
public class TheatreController {
	
	@Autowired
	private TheatreRepo theatreRepo;
	
	
	
	@Autowired
	private TheatreService theatreService;
	
	
	@PostMapping("addTheatre")
	public void addTheatre(@RequestBody Theatre theatre) {
		
		
			theatreService.addTheatre(theatre);
	}
		
	@GetMapping("api/v1/getTheatres")
	public List<Theatre> getAllTheatrs(){
		
		
		return theatreService.getAllTheatres();
	}
	
	@GetMapping("/api/vi/getMovie/{movieName}")
	
	public Set<Theatre> getTheatreByMovieName(@PathVariable String movieName, @RequestParam LocalDate date){
		
		return theatreService.getMoviesByName(movieName, date);
	}
	
	@PostMapping("api/v1/addMovietoTheatre/{threatreId}")
	public void addMovieToTheater(@PathVariable Long threatreId, @RequestBody Movie movie) {
		
		theatreService.addMovieToTheatre(threatreId, movie);
	}
	
	@DeleteMapping("api/v1/deleteShow/{theatreId}")
	public void deleteMovie(@PathVariable Long theatreId, @RequestParam String movieName, 
			@RequestParam String showTime) {
		
		theatreService.deleteShowByCriteria(theatreId, movieName, showTime);
		
		
		
	}
			
		
	

}


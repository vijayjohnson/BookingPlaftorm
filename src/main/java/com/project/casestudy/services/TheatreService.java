package com.project.casestudy.services;


import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.casestudy.entities.Movie;
import com.project.casestudy.entities.Theatre;
import com.project.casestudy.repositories.MovieRepo;
import com.project.casestudy.repositories.ShowRepo;
import com.project.casestudy.repositories.TheatreRepo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Service



public class TheatreService {
	
	@Autowired
	private MovieRepo movieRepo;
	@Autowired
	private TheatreRepo theatreRepo;
	@Autowired
	private ShowRepo showRepo;
	
	
	public Set<Theatre> getMoviesByName(String movieName, LocalDate date){
		
		List<Movie> movies = movieRepo.findByMovieName(movieName);
		
		return movies.stream().
		filter(e->e.getTillDate()!=null && (e.getTillDate().isAfter(date)||
				e.getTillDate().equals(date))).
			flatMap(m->m.getTheatres().stream()).collect(Collectors.toSet());
			
	}
	
	public  List<Theatre> getAllTheatres(){
		
		return theatreRepo.findAll();
	}
	
	public void addTheatre(Theatre theatre) {
		
		theatreRepo.save(theatre);
	}
	
	public void deleteShowByCriteria(Long id, String movieName, String showTime) {
		
		Long showId = theatreRepo.findById(id).get().getMovies().stream().
				filter(m->m.getMovieName().equals(movieName)).
				findFirst().get().getShows().stream().
				filter(s->s.getShowTime().equals(showTime)).findFirst().get().getId();
		
		showRepo.deleteById(showId);
	}
	
	public void addMovieToTheatre(Long theatreId, Movie movie) {
		
		theatreRepo.findById(theatreId).ifPresent(t->t.getMovies().add(movie));
	}
	
	
	
	

}

package com.project.casestudy.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String movieName;
	private String genre;
	private LocalDate tillDate;
	
	@JsonIgnore
	@ManyToMany(mappedBy= "movies", fetch=FetchType.LAZY)
	@Cascade({CascadeType.SAVE_UPDATE,CascadeType.MERGE, CascadeType.PERSIST})
	private Set<Theatre> theatres;
	
	@OneToMany
	@JoinColumn(name="movie_id")
	//@OneToMany(mappedBy = "movie",  orphanRemoval=true, fetch=FetchType.LAZY)
	@Cascade({CascadeType.ALL})
	private Set<Shows> shows;
	

}

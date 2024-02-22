package com.project.casestudy.entities;

import java.util.List;
import java.util.Set;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Generated;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Theatre {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String city;
	private Long capacity;
	@ManyToMany
	@Cascade({CascadeType.SAVE_UPDATE,CascadeType.MERGE, CascadeType.PERSIST})
	@JoinTable(name="theatre_movie", 
			joinColumns = @JoinColumn(name ="theatre_id"), 
			inverseJoinColumns = @JoinColumn(name="movie_id"))
	private Set<Movie> movies;
	
	
	
	

}

package com.project.casestudy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.casestudy.entities.Booking;
import com.project.casestudy.models.BookingDTO;

import com.project.casestudy.services.BookingService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class BookingController {
	
	@Autowired
	BookingService service;
	
	@PostMapping("/bookTickets")
	public void bookTickets(@RequestBody BookingDTO bookingDto) {
		
		service.bookMovieTickets(bookingDto);
		
	}
	
	@GetMapping("/getBookings")
	public List<Booking> getAllBookings(){
		
		return service.fetchBookings();
		
		
	}
		
		
	}




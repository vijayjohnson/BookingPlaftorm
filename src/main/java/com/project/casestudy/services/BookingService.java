package com.project.casestudy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.casestudy.entities.Booking;
import com.project.casestudy.models.BookingDTO;
import com.project.casestudy.models.MovieTicketBooking;
import com.project.casestudy.models.NoDiscountApplier;
import com.project.casestudy.models.ShowTimeDiscountApplier;
import com.project.casestudy.models.ThirdTicketDiscountApplier;
import com.project.casestudy.repositories.BookingRepo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Component
public class BookingService {
	@Autowired
	private MovieTicketBooking ticketbooking;
	
	
	private Booking booking;
	private Long bookingId;
	@Autowired
	private BookingRepo bookingRepo;
	
	private enum status{
		confirmed,
		failed,
		onhold
	}
	
	public void bookMovieTickets(BookingDTO bookingDto) {
		
		
		
		populateBooking(bookingDto);
		if(processpayment(bookingDto)) {
			
			booking.setStatus(status.confirmed.toString());
		}else {
			
			booking.setStatus(status.failed.toString());
		}
		
		bookingRepo.save(booking);
		
		
		
	}
	
	public List<Booking> fetchBookings(){
		
		return bookingRepo.findAll();
	}
	
	
	private boolean processpayment(BookingDTO bookingDto) {

			return true;
		
	}


	private void populateBooking(BookingDTO bookingDto) {
		this.booking = new Booking();
		booking.setDate(bookingDto.getDate());
		booking.setMovieName(bookingDto.getMovieName());
		booking.setNoOfTickets(bookingDto.getNoOfTickets());
		booking.setShowTime(bookingDto.getShowTime());
		booking.setTheatreId(bookingDto.getTheatreId());
		booking.setTotalPrice(ticketbooking.calculateTotalPrice(bookingDto));
		booking.setTax(ticketbooking.calculateTax(null));
		
		
	}


	

}

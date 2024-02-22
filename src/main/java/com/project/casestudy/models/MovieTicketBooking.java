package com.project.casestudy.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Component
public  class MovieTicketBooking {
	
	@Autowired
	@Qualifier("showTime")
	private DiscountApplier showTimeDiscountApplier;
	
	@Autowired
	@Qualifier("thirdTicket")
	private DiscountApplier thirdTickeDiscountApplier;
	
	@Autowired
	@Qualifier("NoDiscount")
	private DiscountApplier nodiscountApplier;
	
	
	public Double calculateTotalPrice(BookingDTO booking) {
		
		if(booking.getNoOfTickets()>2) {
			
			return thirdTickeDiscountApplier.calculatePriceAfterDiscount(booking);
			
		} else if(isAfternoonShow(booking)) {
			
			return showTimeDiscountApplier.calculatePriceAfterDiscount(booking);
		}else {
			
			return nodiscountApplier.calculatePriceAfterDiscount(booking);
		}
		
		
		
		
		
	}
	
public boolean isAfternoonShow(BookingDTO booking) {
		
		return Integer.parseInt(booking.getShowTime())>1200  && Integer.parseInt(booking.getShowTime()) <1500;
	}
	
	public Double  calculateTax(Double price) {
		
		return 0.0;
		
	}

}

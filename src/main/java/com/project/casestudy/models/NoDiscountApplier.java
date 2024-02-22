package com.project.casestudy.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.casestudy.repositories.MovieRepo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component("NoDiscount")
public class NoDiscountApplier implements DiscountApplier{
	@Autowired
	private MovieRepo movieRepo;

	@Override
	public Double calculatePriceAfterDiscount(BookingDTO booking) {
		
		Double price =movieRepo.findByMovieName(booking.getMovieName()).stream().
				filter(m->m.getMovieName().equals(booking.getMovieName())).
				findFirst().get().getShows().stream().
				filter(s->s.getShowTime().equals(booking.getShowTime())).
				findFirst().get().getPrice();
		
		return booking.getNoOfTickets()*price;
	}

}

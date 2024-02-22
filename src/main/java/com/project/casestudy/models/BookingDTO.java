package com.project.casestudy.models;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
public class BookingDTO {
	
	private String movieName;
	private Integer noOfTickets;
	private Long theatreId;
	private String showTime;
	private LocalDate date;

}

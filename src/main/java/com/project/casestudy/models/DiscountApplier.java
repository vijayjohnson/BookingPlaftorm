package com.project.casestudy.models;

public interface DiscountApplier {
	
	public abstract Double calculatePriceAfterDiscount(BookingDTO booking);

}

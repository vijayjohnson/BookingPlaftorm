package com.project.casestudy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.casestudy.entities.Booking;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Long> {

}

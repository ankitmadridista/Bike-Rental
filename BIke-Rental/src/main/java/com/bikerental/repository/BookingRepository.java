package com.bikerental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bikerental.model.Booking;
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

	public List<Booking> findAllByCustId(long id);
	public List<Booking> findAllByBikeId(long id);
	public List<Booking> findAllByProvId(long id);
}

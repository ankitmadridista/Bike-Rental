package com.bikerental.service;

import java.util.List;

import com.bikerental.model.Booking;

public interface BookingService {

	public List<Booking> getAllBooking();
	public Booking getByBookId(long id);
	public List<Booking> getByCustId(long custId);
	public List<Booking> getByBikeId(long bikeId);
	public List<Booking> getByProvId(long provId);
	public void deleteBooking(long id);
	public void modifyBooking(Booking booking);
	public Booking addBooking(Booking booking);	
	
	public void modifyBookingStatusToRejected(long bookId);
	public void modifyBookingStatusToBooked(long bookId);
	
}
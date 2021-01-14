package com.bikerental.cntr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bikerental.model.Booking;
import com.bikerental.service.BookingService;

public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@GetMapping(value = "admin-booking")
	public List<Booking> getBookingList(){
		return bookingService.getAllBooking();
	}
	
	@GetMapping(value ="cust-booking/{custId}")
	public List<Booking> getCustBooking(@PathVariable long custId){
		return bookingService.getByCustId(custId);
	}
	
	@GetMapping(value = "bike-booking/{bikeId}")
	public List<Booking> getBikeBooking(@PathVariable long bikeId){
		return bookingService.getByCustId(bikeId);
	}
	
	@GetMapping(value="booking/{id}")
	public Booking getBookingDetails(@PathVariable long id){
		return bookingService.getByBookId(id);
	}
	
	@GetMapping(value="prov-booking/{provId}")
	public List<Booking> getProvBooking(@PathVariable long provId)
	{
		return bookingService.getByProvId(provId);
	} 
	
	@DeleteMapping(value="booking/{id}")
	public String deleteBooking(@PathVariable long id) {
		bookingService.deleteBooking(id);
		return "Sucess";
	}
	@PutMapping(value="booking")
	public String updateBooking(@RequestBody Booking book) {
		bookingService.modifyBooking(book);
		return "Sucess";
	}
	
	@PostMapping(value ="booking")
	public Booking addBooking(@RequestBody Booking booking) throws Exception {		
			booking.setBookingStatus("Pending");
			return bookingService.addBooking(booking);		
	}
	
	//to update booking status from pending to booked
	@PutMapping(value="update-booking-booked")
	public String updateBookingStatusToBooked(@PathVariable long bookingId) {
		bookingService.modifyBookingStatusToBooked(bookingId);
		return "Sucess";
	}
	
	//to update booking status from pending to rejected
	@PutMapping(value="update-booking-rejected")
	public String updateBookingStatusToRej(@PathVariable long bookingId) {
		bookingService.modifyBookingStatusToRejected(bookingId);
		return "Sucess";
	}
}

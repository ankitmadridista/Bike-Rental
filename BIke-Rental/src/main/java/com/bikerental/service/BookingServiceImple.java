package com.bikerental.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikerental.model.Booking;
import com.bikerental.repository.BookingRepository;
@Service
public class BookingServiceImple implements BookingService{
	@Autowired
	private BookingRepository bookingRepository;
	
	@Override
	public List<Booking> getAllBooking() {
		
		Iterable<Booking> itr = bookingRepository.findAll();
		Iterator<Booking> it = itr.iterator();
		List<Booking> li = new ArrayList<Booking>();
		
		while(it.hasNext()) {
			li.add(it.next());
		}
		return li;
	}

	@Override
	public Booking getByBookId(long id) {
		return bookingRepository.getOne(id);
	}

	@Override
	public List<Booking> getByCustId(long custId) {
		Iterable<Booking> itr = bookingRepository.findAllByCustId(custId);
		Iterator<Booking> it = itr.iterator();
		List<Booking> li = new ArrayList<Booking>();
		
		while(it.hasNext()) {
			li.add(it.next());
		}
		return li;
		 
	}

	@Override
	public List<Booking> getByBikeId(long bikeId) {
		Iterable<Booking> itr = bookingRepository.findAllByBikeId(bikeId);
		Iterator<Booking> it = itr.iterator();
		List<Booking> li = new ArrayList<Booking>();
		
		while(it.hasNext()) {
			li.add(it.next());
		}
		return li;
	}

	@Override
	public List<Booking> getByProvId(long provId) {
		Iterable<Booking> itr = bookingRepository.findAllByProvId(provId);
		Iterator<Booking> it = itr.iterator();
		List<Booking> li = new ArrayList<Booking>();
		
		while(it.hasNext()) {
			li.add(it.next());
		}
		
		return li;
	}

	@Override
	public void deleteBooking(long id) {
		bookingRepository.deleteById(id);
		
	}
	@Override
	public void modifyBooking(Booking booking) {
		bookingRepository.save(booking);
	}

	@Override
	public Booking addBooking(Booking booking) {
		return bookingRepository.save(booking);
	}

	@Override
	public void modifyBookingStatusToRejected(long bookingId) {
		bookingRepository.updateBookingStatus("Rejected", bookingId);
	}
	
	
	@Override
	public void modifyBookingStatusToBooked(long bookingId) {
		bookingRepository.updateBookingStatus("Booked", bookingId);
	}
}
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
	private BookingRepository bookRepo;
	
	@Override
	public List<Booking> getAllBooking() {
		
		Iterable<Booking> itr = bookRepo.findAll();
		Iterator<Booking> it = itr.iterator();
		List<Booking> li = new ArrayList<Booking>();
		
		while(it.hasNext()) {
			li.add(it.next());
		}
		return li;
	}

	

	@Override
	public Booking getByBookId(long id) {
		return bookRepo.getOne(id);
	}

	@Override
	public List<Booking> getByCustId(long custId) {
		Iterable<Booking> itr = bookRepo.findAllByCustId(custId);
		Iterator<Booking> it = itr.iterator();
		List<Booking> li = new ArrayList<Booking>();
		
		while(it.hasNext()) {
			li.add(it.next());
		}
		return li;
		 
	}

	@Override
	public List<Booking> getByBikeId(long bikeId) {
		Iterable<Booking> itr = bookRepo.findAllByBikeId(bikeId);
		Iterator<Booking> it = itr.iterator();
		List<Booking> li = new ArrayList<Booking>();
		
		while(it.hasNext()) {
			li.add(it.next());
		}
		return li;
	}

	@Override
	public List<Booking> getByProvId(long provId) {
		Iterable<Booking> itr = bookRepo.findAllByProvId(provId);
		Iterator<Booking> it = itr.iterator();
		List<Booking> li = new ArrayList<Booking>();
		
		while(it.hasNext()) {
			li.add(it.next());
		}
		
		return li;
	}

	@Override
	public void deleteBooking(long id) {
		bookRepo.deleteById(id);
		
	}
	@Override
	public void modifyBooking(Booking booking) {
		bookRepo.save(booking);
	}

	@Override
	public Booking addBooking(Booking booking) {
		return bookRepo.save(booking);
	}

}
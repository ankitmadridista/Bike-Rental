package com.bikerental.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bikerental.model.Booking;
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

	public List<Booking> findAllByCustId(long id);
	public List<Booking> findAllByBikeId(long id);
	public List<Booking> findAllByProvId(long id);
	
	@Modifying
	@Query("UPDATE booking u SET u.bookStatus = ?1 where u.bookId=?2")
	@Transactional
	public void updateBookingStatus(String bookStatus, long bookId);
	
	public List<Booking> findAllByBookStatus(String bookStatus);
	
}

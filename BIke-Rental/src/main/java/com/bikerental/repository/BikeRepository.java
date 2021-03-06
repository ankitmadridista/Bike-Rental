package com.bikerental.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bikerental.model.Bike;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Long>{
	public Bike findByBikeNo(String bikeNo);
	public List<Bike> findAllByProvId(long id);
	
	@Modifying
	@Query("DELETE from bike ud where ud.provId=?1")
	@Transactional
	public void deleteByProvId(long id);

	//jpql
	@Query("SELECT ud from bike ud where ud.bikeStatus=?1")
	public List<Bike> findAllBikesByStatus(String status);
	

	@Modifying
	@Query("UPDATE bike u SET u.bikeStatus = ?1 where u.bikeId=?2")
	@Transactional
	public void updateBikeStatus(String bikeStatus, long bikeId);
	
}

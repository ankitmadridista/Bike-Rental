package com.bikerental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bikerental.model.Bike;


public interface BikeRepository extends JpaRepository<Bike, Long>{
	public Bike findByBikeNo(String bikeNo);
	public List<Bike> findAllByProvId(long id);
	
//	@Query("select * from Bike u where u.status = Available")
//	  List<Bike> findAllAvailableBikes();

//	@Query("select u from User u where u.firstname = :firstname or u.lastname = :lastname")
//	  User findByLastnameOrFirstname(@Param("lastname") String lastname,
//	                                 @Param("firstname") String firstname);

	//jpql
	@Query("SELECT ud from bike ud where ud.bikeStatus=?1")
	public List<Bike> findAllBikesByStatus(String status);
}

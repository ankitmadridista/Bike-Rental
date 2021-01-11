package com.bikerental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikerental.model.Bike;


public interface BikeRepository extends JpaRepository<Bike, Long>{
	public Bike findByBikeNo(String bikeNo);
	public List<Bike> findAllByProvId(long id);
}

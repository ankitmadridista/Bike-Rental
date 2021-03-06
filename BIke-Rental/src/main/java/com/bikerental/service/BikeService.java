package com.bikerental.service;

import java.util.List;

import com.bikerental.model.Bike;

public interface BikeService {
	public Bike addBike(Bike bike);
	public void removeBike(long id);
	public void removeBikeByProvId(long ProvId);
	public Bike getBike(long id);
	public Bike modifyBike(Bike bike);
	public List<Bike> getAll();
	public Bike getByBikeNo(String bikeNo);
	public List<Bike> getByProvId(long provId);
	public List<Bike> getAllBikesByStatus(String status);
	public void modifyBikeStatusToAvailable(long bikeId);
	public void modifyBikeStatusToRejected(long bikeId);
	public void modifyBikeStatusToReserve(long bikeId);
	public void modifyBikeStatusToBooked(long bikeId);	
	
}	

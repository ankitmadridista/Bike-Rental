package com.bikerental.service;

import java.util.List;

import com.bikerental.model.Bike;
import com.bikerental.model.Provider;

public interface BikeService {
	public Bike addBike(Bike bike);
	public void removeBike(long id);
	public Bike getBike(long id);
	public void modifyBike(Bike bike);
	public List<Bike> getAll();
	public Bike getByBikeNo(String bikeNo);
	public List<Bike> getByProvId(long provId);
	//public List<Provider> getAllProv();
}	

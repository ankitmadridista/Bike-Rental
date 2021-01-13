package com.bikerental.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikerental.model.Bike;
import com.bikerental.repository.BikeRepository;
import com.bikerental.repository.ProviderRepository;

@Service
public class BikeServiceImple implements BikeService {
	@Autowired
	private BikeRepository bikeRepository;
	
	@Override
	public Bike addBike(Bike bike) {		
		return bikeRepository.save(bike);
	}

	@Override
	public void removeBike(long id) {
		bikeRepository.deleteById(id);
	}

	@Override
	public Bike getBike(long id) {
		Optional<Bike> opt = bikeRepository.findById(id);
		return opt.get();
	}

	@Override
	public String modifyBike(Bike bike) {
		bikeRepository.save(bike);
		return "success";
	}

	@Override
	public List<Bike> getAll() {
		Iterable<Bike> itr = bikeRepository.findAll();
		Iterator<Bike> it = itr.iterator();
		List<Bike> li = new ArrayList<Bike>();
		
		while(it.hasNext()) {
			li.add(it.next());
		}
		
		return li;
	}

	@Override
	public Bike getByBikeNo(String bikeNo) {
		
		return bikeRepository.findByBikeNo(bikeNo);
	}

	@Override
	public List<Bike> getByProvId(long provId) {		
		return bikeRepository.findAllByProvId(provId);
	}

	@Override
	public List<Bike> getAllBikesByStatus(String status) {
		return bikeRepository.findAllBikesByStatus(status);
	}

	@Override
	public void modifyBikeStatusToAvailable(long bikeId) {
		bikeRepository.updateBikeStatus("Available",bikeId);
		
	}
	@Override
	public void modifyBikeStatusToRejected(long bikeId) {
		bikeRepository.updateBikeStatus("Rejected",bikeId);
		
	}

	@Override
	public void removeBikeByProvId(long ProvId) {
		bikeRepository.deleteByProvId(ProvId);
		
	}


}

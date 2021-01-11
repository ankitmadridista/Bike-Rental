package com.bikerental.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikerental.model.Bike;
import com.bikerental.model.Provider;
import com.bikerental.repository.BikeRepository;
import com.bikerental.repository.ProviderRepository;

@Service
public class BikeServiceImple implements BikeService {
	@Autowired
	private BikeRepository bikeRepository;
	private ProviderRepository providerRepository;
	
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
	public void modifyBike(Bike bike) {
		bikeRepository.save(bike);
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

//	@Override
//	public List<Provider> getAllProv() {
//		Iterable<Provider> itr = providerRepository.findAll();
//		Iterator<Provider> it = itr.iterator();
//		List<Provider> li = new ArrayList<Provider>();
//		
//		while(it.hasNext()) {
//			li.add(it.next());
//		}
//		
//		return li;
//	}

}

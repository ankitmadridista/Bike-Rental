package com.bikerental.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikerental.model.Provider;
import com.bikerental.repository.ProviderRepository;

@Service
public class ProviderServiceImple implements ProviderService {
	
	@Autowired
	private ProviderRepository providerRepository;

	@Override
	public Provider addProvider(Provider provider) {
		// TODO Auto-generated method stub
		return providerRepository.save(provider);

	}

	@Override
	public void removeProvider(long id) {
		// TODO Auto-generated method stub
		providerRepository.deleteById(id);
	}

	@Override
	public Provider getProvider(long id) {
		// TODO Auto-generated method stub
		Optional<Provider> opt = providerRepository.findById(id);
		return opt.get();
	}

	@Override
	public void modifyProvider(Provider provider) {
		// TODO Auto-generated method stub
		providerRepository.save(provider);

	}

	@Override
	public List<Provider> getAll() {
		// TODO Auto-generated method stub
		Iterable<Provider> itr = providerRepository.findAll();
		Iterator<Provider> it = itr.iterator();
		List<Provider> li = new ArrayList<Provider>();
		
		while(it.hasNext()) {
			li.add(it.next());
		}
		
		return li;
	}

	

	@Override
	public Provider findProviderEmailAndPassword(String provEmail, String provPassword) {
		return providerRepository.findByProvEmailAndProvPassword(provEmail, provPassword);
	}

	@Override
	public Provider findProviderEmail(String provEmail) {		
		return providerRepository.findByProvEmail(provEmail);
	}

}

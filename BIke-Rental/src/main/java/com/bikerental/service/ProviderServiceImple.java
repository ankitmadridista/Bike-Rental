package com.bikerental.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bikerental.model.Provider;
import com.bikerental.repository.ProviderRepository;

@Service
public class ProviderServiceImple implements ProviderService {
	
	@Autowired
	private ProviderRepository providerRepository;

	@Override
	public Provider addProvider(Provider provider) {
		return providerRepository.save(provider);

	}

	@Override
	public void removeProvider(long id) {
		providerRepository.deleteById(id);
	}

	@Override
	public Provider getProvider(long id) {
		Optional<Provider> opt = providerRepository.findById(id);
		return opt.get();
	}

	@Override
	public void modifyProvider(Provider provider) {
		providerRepository.save(provider);
	}

	@Override
	public List<Provider> getAll() {
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
	
	@Override
	public String encoder(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(password);
		return encodedPassword;	
	}
	
	@Override
	public boolean decoder(String password, String encoded) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		boolean isPasswordMatch = passwordEncoder.matches(password, encoded);
		return isPasswordMatch;
	}

}

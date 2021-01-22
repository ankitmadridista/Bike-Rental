package com.bikerental.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bikerental.model.Admin;
import com.bikerental.model.Bike;
import com.bikerental.model.Provider;
import com.bikerental.repository.AdminRepository;
import com.bikerental.repository.BikeRepository;
import com.bikerental.repository.ProviderRepository;

@Service
public class AdminServiceImple implements AdminService {

	@Autowired
	private AdminRepository adminRepo;
	@Autowired
	private ProviderRepository providerRepository;
	@Autowired
	private BikeRepository bikeRepository;
	
	@Override
	public Admin addAdmin(Admin admin) {
		return adminRepo.save(admin);
	}

	@Override
	public void removeAdmin(long id) {
		adminRepo.deleteById(id);

	}

	@Override
	public Admin showMyProfile(long id) {
		Optional<Admin> opt = adminRepo.findById(id);	
		return opt.get();
	}

	@Override
	public Admin modifyMyProfile(Admin a) {
		return adminRepo.save(a);
	}

	@Override
	public List<Admin> getAllAdmin() {	
		return adminRepo.findAll();
	}

	@Override
	public Admin getByEmail(String adminEmail) {
		return adminRepo.findByAdminEmail(adminEmail);
	}

	@Override
	public List<Provider> getAllProvider() {		
		return providerRepository.findAll();
	}

	@Override
	public void modifyProvider(Provider provider) {
		providerRepository.save(provider);		
	}

	@Override
	public void removeProvider(long id) {
		providerRepository.deleteById(id);		
	}

	@Override
	public List<Bike> getAllBikes() {
		return bikeRepository.findAll();
	}

	@Override
	public Admin findAdminEmailAndPassword(String adminEmail, String adminPassword) {
		
		return adminRepo.findByAdminEmailAndAdminPassword(adminEmail, adminPassword);
	}
	
	@Override
	public Admin findAdminEmail(String adminEmail) {
		return adminRepo.findByAdminEmail(adminEmail);
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

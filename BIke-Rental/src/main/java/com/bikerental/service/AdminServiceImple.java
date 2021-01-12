package com.bikerental.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		Admin admin=adminRepo.getOne(id);		
		return admin;
	}

	@Override
	public void modifyMyProfile(Admin a) {
		adminRepo.save(a);
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
	
//	@Override
//	public List<Bike> getAllAvailableBikes() {
//		return adminRepo.findAllAvailableBikes();
//	}
	
//	public void updateProductDetails(int pid, int spid) {
//		String sql = "update productdetails SET sp_id ="+spid+" WHERE product_id="+pid;
//		System.out.println("SQL "+sql);
//		jdbcTemplate.execute(sql);
//	}
	
	

}

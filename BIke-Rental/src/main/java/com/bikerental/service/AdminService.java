package com.bikerental.service;

import java.util.List;

import com.bikerental.model.Admin;
import com.bikerental.model.Bike;
import com.bikerental.model.Provider;

public interface AdminService {
	public Admin addAdmin(Admin admin);
	public void removeAdmin(long id);
	public Admin showMyProfile(long id);
	public Admin modifyMyProfile(Admin a);
	public List<Admin> getAllAdmin();
	public Admin getByEmail(String adminEmail);
	public List<Provider> getAllProvider();
	public void modifyProvider(Provider provider);
	public void removeProvider(long id);
	public List<Bike> getAllBikes();
	public Admin findAdminEmailAndPassword(String adminEmail, String adminPassword);
	public Admin findAdminEmail(String adminEmail);
	public String encoder(String password);
	public boolean decoder(String password, String encoded);
}

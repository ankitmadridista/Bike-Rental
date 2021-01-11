package com.bikerental.service;

import java.util.List;


import com.bikerental.model.Provider;

public interface ProviderService {
	
	public Provider addProvider(Provider provider);
	public void removeProvider(long id);
	public Provider getProvider(long id);
	public void modifyProvider(Provider provider);
	public List<Provider> getAll();
	public Provider findProviderEmailAndPassword(String provEmail, String provPassword);
	public Provider findProviderEmail(String provEmail);
	
		
}

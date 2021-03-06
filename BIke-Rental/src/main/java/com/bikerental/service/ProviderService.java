package com.bikerental.service;

import java.util.List;


import com.bikerental.model.Provider;

public interface ProviderService {
	
	public Provider addProvider(Provider provider);
	public void removeProvider(long id);
	public Provider getProvider(long id);
	public Provider modifyProvider(Provider provider);
	public List<Provider> getAll();
	public Provider findProviderEmailAndPassword(String provEmail, String provPassword);
	public Provider findProviderEmail(String provEmail);
	public String encoder(String password);
	public boolean decoder(String password, String encoded);
	
		
}

package com.bikerental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bikerental.model.Provider;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {
	public Provider findByProvEmailAndProvPassword(String provEmail, String provPassword );
	public Provider findByProvEmail(String provEmail);
}

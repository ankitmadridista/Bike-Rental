package com.bikerental.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bikerental.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
	public Admin findByAdminEmail(String adminEmail);
	public Admin findByAdminEmailAndAdminPassword(String adminEmail, String adminPassword);
	

	
}

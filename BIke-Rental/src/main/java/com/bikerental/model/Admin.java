package com.bikerental.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Admin {
	@Id
	@GeneratedValue
	long adminId;
	//@Column(unique=true)
	String adminName;
	String adminEmail;
	String adminPassword;
	double adminWallet;
	
	public Admin() {
		super();
	}

	public Admin(long adminId, String adminName, String adminEmail, String adminPassword, double adminWallet) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminEmail = adminEmail;
		this.adminPassword = adminPassword;
		this.adminWallet = adminWallet;
	}


	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public double getAdminWallet() {
		return adminWallet;
	}

	public void setAdminWallet(double adminWallet) {
		this.adminWallet = adminWallet;
	}
	
	
}

package com.bikerental.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// uniqueConstraints = {@UniqueConstraint(columnNames = {"Email"})}
@Entity
@Table(name="provider")
public class Provider {
	@Id
	@GeneratedValue
	long provId;
	@Column(unique=true)
	String provEmail;
	String provPassword;
	String provFname;
	String provDateOfBirth;
	int provAge;
	String provContactNo;
	String provAadhar;
	String provAddress;
	String provCity;
	String provState;
	String provPin;
	double provWallet;
	
	public Provider() {
	}
	
	public Provider(long provId, String provEmail, String provPassword, String provFname, String provDateOfBirth,
			int provAge, String provContactNo, String provAadhar, String provAddress, String provCity, String provState,
			String provPin, double provWallet) {
		super();
		this.provId = provId;
		this.provEmail = provEmail;
		this.provPassword = provPassword;
		this.provFname = provFname;
		this.provDateOfBirth = provDateOfBirth;
		this.provAge = provAge;
		this.provContactNo = provContactNo;
		this.provAadhar = provAadhar;
		this.provAddress = provAddress;
		this.provCity = provCity;
		this.provState = provState;
		this.provPin = provPin;
		this.provWallet = provWallet;
	}


	public String getProvEmail() {
		return provEmail;
	}
	public void setProvEmail(String provEmail) {
		this.provEmail = provEmail;
	}
	public String getProvPassword() {
		return provPassword;
	}
	public void setProvPassword(String provPassword) {
		this.provPassword = provPassword;
	}
	public String getProvFname() {
		return provFname;
	}
	public void setProvFname(String provFname) {
		this.provFname = provFname;
	}	
	
	public int getProvAge() {
		return provAge;
	}
	public void setProvAge(int provAge) {
		this.provAge = provAge;
	}
	
	public String getProvAadhar() {
		return provAadhar;
	}
	public void setProvAadhar(String provAadhar) {
		this.provAadhar = provAadhar;
	}
	
	public String getProvAddress() {
		return provAddress;
	}
	public void setProvAddress(String provAddress) {
		this.provAddress = provAddress;
	}
	public String getProvCity() {
		return provCity;
	}
	public void setProvCity(String provCity) {
		this.provCity = provCity;
	}
	public String getProvState() {
		return provState;
	}
	public void setProvState(String provState) {
		this.provState = provState;
	}
	
	
	public long getProvId() {
		return provId;
	}
	public void setProvId(long provId) {
		this.provId = provId;
	}
	public String getProvDateOfBirth() {
		return provDateOfBirth;
	}
	public void setProvDateOfBirth(String provDateOfBirth) {
		this.provDateOfBirth = provDateOfBirth;
	}
	public String getProvContactNo() {
		return provContactNo;
	}
	public void setProvContactNo(String provContactNo) {
		this.provContactNo = provContactNo;
	}

	public String getProvPin() {
		return provPin;
	}
	public void setProvPin(String provPin) {
		this.provPin = provPin;
	}

	public double getProvWallet() {
		return provWallet;
	}

	public void setProvWallet(double provWallet) {
		this.provWallet = provWallet;
	}
	
	
}

package com.bikerental.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name="customer")
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue
	long custId;
	@Column(unique=true)
	String custEmail;
	String custPassword;
	String custFname;
	String custDateOfBirth;
	String custDrivingLicNo;
	int custAge;
	String custContactNo;
	String custAadhar;
	String custAddress;
	String custCity;
	String custState;
	String custPin;
	boolean custIsActive;
	double custWallet;
	

	public Customer() {
	}
	
	
	public Customer(long custId, String custEmail, String custPassword, String custFname, String custDateOfBirth,
			String custDrivingLicNo, int custAge, String custContactNo, String custAadhar, String custAddress,
			String custCity, String custState, String custPin, boolean custIsActive, double custWallet) {
		super();
		this.custId = custId;
		this.custEmail = custEmail;
		this.custPassword = custPassword;
		this.custFname = custFname;
		this.custDateOfBirth = custDateOfBirth;
		this.custDrivingLicNo = custDrivingLicNo;
		this.custAge = custAge;
		this.custContactNo = custContactNo;
		this.custAadhar = custAadhar;
		this.custAddress = custAddress;
		this.custCity = custCity;
		this.custState = custState;
		this.custPin = custPin;
		this.custIsActive = custIsActive;
		this.custWallet = custWallet;
	}




	public long getCustId() {
		return custId;
	}
	public void setCustId(long custId) {
		this.custId = custId;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public String getCustPassword() {
		return custPassword;
	}
	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
	}
	public String getCustFname() {
		return custFname;
	}
	public void setCustFname(String custFname) {
		this.custFname = custFname;
	}
	public String getCustDateOfBirth() {
		return custDateOfBirth;
	}
	public void setCustDateOfBirth(String custDateOfBirth) {
		this.custDateOfBirth = custDateOfBirth;
	}
	public String getCustDrivingLicNo() {
		return custDrivingLicNo;
	}
	public void setCustDrivingLicNo(String custDrivingLicNo) {
		this.custDrivingLicNo = custDrivingLicNo;
	}
	public int getCustAge() {
		return custAge;
	}
	public void setCustAge(int custAge) {
		this.custAge = custAge;
	}
	public String getCustContactNo() {
		return custContactNo;
	}
	public void setCustContactNo(String custContactNo) {
		this.custContactNo = custContactNo;
	}
	public String getCustAadhar() {
		return custAadhar;
	}
	public void setCustAadhar(String custAadhar) {
		this.custAadhar = custAadhar;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	public String getCustCity() {
		return custCity;
	}
	public void setCustCity(String custCity) {
		this.custCity = custCity;
	}
	public String getCustState() {
		return custState;
	}
	public void setCustState(String custState) {
		this.custState = custState;
	}
	public String getCustPin() {
		return custPin;
	}
	public void setCustPin(String custPin) {
		this.custPin = custPin;
	}
	public boolean isCustIsActive() {
		return custIsActive;
	}
	public void setCustIsActive(boolean custIsActive) {
		this.custIsActive = custIsActive;
	}

	public double getCustWallet() {
		return custWallet;
	}

	public void setCustWallet(double custWallet) {
		this.custWallet = custWallet;
	}
	
}
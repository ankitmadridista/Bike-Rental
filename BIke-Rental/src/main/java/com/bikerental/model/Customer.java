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
	//String provRcBookNo;
	String custAddress;
	String custCity;
	String custState;
	String custPin;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Customer(long custId, String custDrivingLicNo,String custEmail, String custPassword, String custFname, String custDateOfBirth,
			int custAge, String custContactNo, String custAadhar, String custAddress, String custCity, String custState,
			String custPin) {
		super();
		this.custId = custId;
		this.custEmail = custEmail;
		this.custPassword = custPassword;
		this.custFname = custFname;
		this.custDateOfBirth = custDateOfBirth;
		this.custAge = custAge;
		this.custContactNo = custContactNo;
		this.custAadhar = custAadhar;
		this.custAddress = custAddress;
		this.custCity = custCity;
		this.custState = custState;
		this.custPin = custPin;
		this.custDrivingLicNo = custDrivingLicNo;
	}

	public long getCustId() {
		return custId;
	}
	public void setCustId(long custId) {
		this.custId = custId;
	}
	
	
	public String getcustDrivingLicNo() {
		return custDrivingLicNo;
	}
	public void setcustDrivingLicNo(String custDrivingLicNo) {
		this.custDrivingLicNo = custDrivingLicNo;
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
	public String getcustDateOfBirth() {
		return custDateOfBirth;
	}
	public void setcustDateOfBirth(String custDateOfBirth) {
		this.custDateOfBirth = custDateOfBirth;
	}
	public int getCustAge() {
		return custAge;
	}
	public void setCustAge(int custAge) {
		this.custAge = custAge;
	}
	public String getcustContactNo() {
		return custContactNo;
	}
	public void setcustContactNo(String custContactNo) {
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
	
	
	

}
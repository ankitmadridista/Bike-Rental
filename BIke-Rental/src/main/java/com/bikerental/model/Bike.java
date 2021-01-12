package com.bikerental.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="bike")
@Table(name="bike")
public class Bike {
	@Id
	@GeneratedValue
	long bikeId;
	long provId;
	String typeOfGear;
	String brandOfBike;
	String modelOfBike;
	String rcBookNo;
	double chargesPerHour;
	String availableLocation;
	String bikeStatus;
	String bikeNo;
	//double depositAmount;
	double avgPerLtr;
	
	public Bike() {
		super();
	}
	
	public Bike(long bikeId, long provId, String typeOfGear, String brandOfBike, String modelOfBike, String rcBookNo,
			double chargesPerHour, String availableLocation, String bikeStatus, String bikeNo, double avgPerLtr) {
		super();
		this.bikeId = bikeId;
		this.provId = provId;
		this.typeOfGear = typeOfGear;
		this.brandOfBike = brandOfBike;
		this.modelOfBike = modelOfBike;
		this.rcBookNo = rcBookNo;
		this.chargesPerHour = chargesPerHour;
		this.availableLocation = availableLocation;
		this.bikeStatus = bikeStatus;
		this.bikeNo = bikeNo;
		this.avgPerLtr = avgPerLtr;
	}

	public long getBikeId() {
		return bikeId;
	}
	public void setBikeId(long bikeId) {
		this.bikeId = bikeId;
	}
	public long getProvId() {
		return provId;
	}
	public void setProvId(long provId) {
		this.provId = provId;
	}
	public String getTypeOfGear() {
		return typeOfGear;
	}
	public void setTypeOfGear(String typeOfGear) {
		this.typeOfGear = typeOfGear;
	}
	public String getBrandOfBike() {
		return brandOfBike;
	}
	public void setBrandOfBike(String brandOfBike) {
		this.brandOfBike = brandOfBike;
	}
	public String getModelOfBike() {
		return modelOfBike;
	}
	public void setModelOfBike(String modelOfBike) {
		this.modelOfBike = modelOfBike;
	}
	public String getRcBookNo() {
		return rcBookNo;
	}
	public void setRcBookNo(String rcBookNo) {
		this.rcBookNo = rcBookNo;
	}
	public double getChargesPerHour() {
		return chargesPerHour;
	}
	public void setChargesPerHour(double chargesPerHour) {
		this.chargesPerHour = chargesPerHour;
	}
	public String getAvailableLocation() {
		return availableLocation;
	}
	public void setAvailableLocation(String availableLocation) {
		this.availableLocation = availableLocation;
	}
	public String getBikeStatus() {
		return bikeStatus;
	}
	public void setBikeStatus(String bikeStatus) {
		this.bikeStatus = bikeStatus;
	}
	public String getBikeNo() {
		return bikeNo;
	}
	public void setBikeNo(String bikeNo) {
		this.bikeNo = bikeNo;
	}
	public double getAvgPerLtr() {
		return avgPerLtr;
	}
	public void setAvgPerLtr(double avgPerLtr) {
		this.avgPerLtr = avgPerLtr;
	}
		
}

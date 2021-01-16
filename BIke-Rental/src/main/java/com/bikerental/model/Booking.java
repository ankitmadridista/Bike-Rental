package com.bikerental.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

 //uniqueConstraints = {@UniqueConstraint(columnNames = {"Email"})}
@Entity(name="booking")
@Table(name="booking")
public class Booking {
	
	@Id
	@GeneratedValue
	long bookId;
	long provId;
	long bikeId;
	long custId;
	double bookChargesPerHours;
	double bookBillAmount;
	double bookReadingAtStart;
	double bookReadingAtEnd;
	double bookDepositAmount;
	double bookInitialFuelCost; 
	
	long bookStartTimeCalc;
	long bookEndTimeCalc;
	
	String bookStartTimeCust;
	String bookEndTimeCust;
	String bookPaymentStatus;
	String bookStatus;
	String bookFeedbackCustomer;
	String bookFeedabackProvider;
	
	public Booking() {
		
	}
	
	public Booking(long bookId, long provId, long bikeId, long custId, double bookChargesPerHours,
			double bookBillAmount, double bookReadingAtStart, double bookReadingAtEnd, double bookDepositAmount,
			double bookInitialFuelCost, long bookStartTimeCalc, long bookEndTimeCalc, String bookStartTimeCust,
			String bookEndTimeCust, String bookPaymentStatus, String bookStatus, String bookFeedbackCustomer,
			String bookFeedabackProvider) {
		
		this.bookId = bookId;
		this.provId = provId;
		this.bikeId = bikeId;
		this.custId = custId;
		this.bookChargesPerHours = bookChargesPerHours;
		this.bookBillAmount = bookBillAmount;
		this.bookReadingAtStart = bookReadingAtStart;
		this.bookReadingAtEnd = bookReadingAtEnd;
		this.bookDepositAmount = bookDepositAmount;
		this.bookInitialFuelCost = bookInitialFuelCost;
		this.bookStartTimeCalc = bookStartTimeCalc;
		this.bookEndTimeCalc = bookEndTimeCalc;
		this.bookStartTimeCust = bookStartTimeCust;
		this.bookEndTimeCust = bookEndTimeCust;
		this.bookPaymentStatus = bookPaymentStatus;
		this.bookStatus = bookStatus;
		this.bookFeedbackCustomer = bookFeedbackCustomer;
		this.bookFeedabackProvider = bookFeedabackProvider;
	}

	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public long getProvId() {
		return provId;
	}
	public void setProvId(long provId) {
		this.provId = provId;
	}
	public long getBikeId() {
		return bikeId;
	}
	public void setBikeId(long bikeId) {
		this.bikeId = bikeId;
	}
	public long getCustId() {
		return custId;
	}
	public void setCustId(long custId) {
		this.custId = custId;
	}
	public double getBookChargesPerHours() {
		return bookChargesPerHours;
	}
	public void setBookChargesPerHours(double bookChargesPerHours) {
		this.bookChargesPerHours = bookChargesPerHours;
	}
	
	public double getBookInitialFuelCost() {
		return bookInitialFuelCost;
	}
	public void setBookInitialFuelCost(double bookInitialFuelCost) {
		this.bookInitialFuelCost = bookInitialFuelCost;
	}
	public double getBookBillAmount() {
		return bookBillAmount;
	}
	public void setBookBillAmount(double bookBillAmount) {
		this.bookBillAmount = bookBillAmount;
	}
	public double getBookReadingAtStart() {
		return bookReadingAtStart;
	}
	public void setBookReadingAtStart(double bookReadingAtStart) {
		this.bookReadingAtStart = bookReadingAtStart;
	}
	public double getBookReadingAtEnd() {
		return bookReadingAtEnd;
	}
	public void setBookReadingAtEnd(double bookReadingAtEnd) {
		this.bookReadingAtEnd = bookReadingAtEnd;
	}
	public double getBookDepositAmount() {
		return bookDepositAmount;
	}
	public void setBookDepositAmount(double bookDepositAmount) {
		this.bookDepositAmount = bookDepositAmount;
	}
	public long getBookStartTimeCalc() {
		return bookStartTimeCalc;
	}
	public void setBookStartTimeCalc(long bookStartTimeCalc) {
		this.bookStartTimeCalc = bookStartTimeCalc;
	}
	public long getBookEndTimeCalc() {
		return bookEndTimeCalc;
	}
	public void setBookEndTimeCalc(long bookEndTimeCalc) {
		this.bookEndTimeCalc = bookEndTimeCalc;
	}
	public String getBookStartTimeCust() {
		return bookStartTimeCust;
	}
	public void setBookStartTimeCust(String bookStartTimeCust) {
		this.bookStartTimeCust = bookStartTimeCust;
	}
	public String getBookEndTimeCust() {
		return bookEndTimeCust;
	}
	public void setBookEndTimeCust(String bookEndTimeCust) {
		this.bookEndTimeCust = bookEndTimeCust;
	}
	public String getBookPaymentStatus() {
		return bookPaymentStatus;
	}
	public void setBookPaymentStatus(String bookPaymentStatus) {
		this.bookPaymentStatus = bookPaymentStatus;
	}
	public String getBookStatus() {
		return bookStatus;
	}
	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}
	public String getBookFeedbackCustomer() {
		return bookFeedbackCustomer;
	}
	public void setBookFeedbackCustomer(String bookFeedbackCustomer) {
		this.bookFeedbackCustomer = bookFeedbackCustomer;
	}
	public String getBookFeedabackProvider() {
		return bookFeedabackProvider;
	}
	public void setBookFeedabackProvider(String bookFeedabackProvider) {
		this.bookFeedabackProvider = bookFeedabackProvider;
	}
	
	
		
}
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
	float bookChargesPerHours;
	int bookBillAmount;
	int bookReadingAtStart;
	int bookReadingAtEnd;
	String bookPaymentStatus;
	String bookingStatus;
	float bookDepositAmount;
	String bookFeedbackCustomer;
	String bookFeedabackProvider;
	public Booking() {
	}
	public Booking(long bookId, long provId, long bikeId, long custId, float bookChargesPerHours, int bookBillAmount,
			int bookReadingAtStart, int bookReadingAtEnd, String bookPaymentStatus, String bookingStatus,
			float bookDepositAmount, String bookFeedbackCustomer, String bookFeedabackProvider) {
		super();
		this.bookId = bookId;
		this.provId = provId;
		this.bikeId = bikeId;
		this.custId = custId;
		this.bookChargesPerHours = bookChargesPerHours;
		this.bookBillAmount = bookBillAmount;
		this.bookReadingAtStart = bookReadingAtStart;
		this.bookReadingAtEnd = bookReadingAtEnd;
		this.bookPaymentStatus = bookPaymentStatus;
		this.bookingStatus = bookingStatus;
		this.bookDepositAmount = bookDepositAmount;
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
	public float getBookChargesPerHours() {
		return bookChargesPerHours;
	}
	public void setBookChargesPerHours(float bookChargesPerHours) {
		this.bookChargesPerHours = bookChargesPerHours;
	}
	public int getBookBillAmount() {
		return bookBillAmount;
	}
	public void setBookBillAmount(int bookBillAmount) {
		this.bookBillAmount = bookBillAmount;
	}
	public int getBookReadingAtStart() {
		return bookReadingAtStart;
	}
	public void setBookReadingAtStart(int bookReadingAtStart) {
		this.bookReadingAtStart = bookReadingAtStart;
	}
	public int getBookReadingAtEnd() {
		return bookReadingAtEnd;
	}
	public void setBookReadingAtEnd(int bookReadingAtEnd) {
		this.bookReadingAtEnd = bookReadingAtEnd;
	}
	public String getBookPaymentStatus() {
		return bookPaymentStatus;
	}
	public void setBookPaymentStatus(String bookPaymentStatus) {
		this.bookPaymentStatus = bookPaymentStatus;
	}
	public String getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	public float getBookDepositAmount() {
		return bookDepositAmount;
	}
	public void setBookDepositAmount(float bookDepositAmount) {
		this.bookDepositAmount = bookDepositAmount;
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
package com.bikerental.repository;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bikerental.model.Customer;


@Repository
public interface CustomerRepository extends JpaRepository <Customer, Long> {
	public Customer findByCustEmailAndCustPassword(String custEmail, String custPassword );
	public Customer findByCustEmail(String custEmail);
	
	//@Query("UPDATE booking u SET u.bookStatus = ?1 where u.bookId=?2")
	@Modifying
	@Query("update customer c set c.custIsActive = ?1 where c.custId=?2")
	@Transactional
	public void updateCustStatusToTrue(boolean status, long custId); 
	
	@Modifying
	@Query("update customer c set c.custIsActive = ?1 where c.custId=?2")
	@Transactional
	public void updateCustStatusToFalse(boolean status, long custId); 
	
	@Modifying
	@Query("update customer c set c.custWallet = ?1 where c.custId=?2")
	@Transactional
	public void insertRefund(double refund, long custId);

}
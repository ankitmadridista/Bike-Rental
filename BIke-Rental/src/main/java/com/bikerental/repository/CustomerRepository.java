package com.bikerental.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bikerental.model.Customer;


@Repository
public interface CustomerRepository extends JpaRepository <Customer, Long> {
	public Customer findByCustEmailAndCustPassword(String custEmail, String custPassword );
	public Customer findByCustEmail(String custEmail);

}
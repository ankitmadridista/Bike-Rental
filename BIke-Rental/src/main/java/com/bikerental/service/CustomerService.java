package com.bikerental.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bikerental.model.Customer;


public interface CustomerService {
	public Customer addCustomer(Customer customer);
	public void removeCustomer(long id);
	public Customer getCustomer(long id);
	public void modifyCustomer(Customer customer);
	public List<Customer> getAll();
	public Customer findCustomerEmailAndPassword(String custEmail, String custPassword);
	public Customer findCustomerEmail(String custEmail);
	public String modifyCustStatusToFalse(boolean status, long custId);
	public String modifyCustStatusToTrue(boolean status, long custId);

}
package com.bikerental.service;

import java.util.List;

import com.bikerental.model.Customer;


public interface CustomerService {
	public Customer addCustomer(Customer customer);
	public void removeCustomer(long id);
	public Customer getCustomer(long id);
	public Customer modifyCustomer(Customer customer) throws Exception;
	public List<Customer> getAll();
	public Customer findCustomerEmailAndPassword(String custEmail, String custPassword);
	public Customer findCustomerEmail(String custEmail);
	public String modifyCustStatusToFalse(long custId);
	public String modifyCustStatusToTrue(long custId);
	public void addRefund(double refund, long custId);
	public String encoder(String password);
	public boolean decoder(String password, String encoded);
}
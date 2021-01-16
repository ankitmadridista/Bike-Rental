package com.bikerental.service;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikerental.model.Customer;
import com.bikerental.repository.CustomerRepository;


@Service
public class CustomerServiceImple implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	@Override
	public void removeCustomer(long id) {
		// TODO Auto-generated method stub
		customerRepository.deleteById(id);
		
	}

	@Override
	public Customer getCustomer(long id) {
		// TODO Auto-generated method stub
		Optional<Customer> opt = customerRepository.findById(id);
		return opt.get();
	}

	@Override
	public void modifyCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerRepository.save(customer);
		
	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		Iterable<Customer> itr = customerRepository.findAll();
		Iterator<Customer> it = itr.iterator();
		List<Customer> li = new ArrayList<Customer>();
		
		while(it.hasNext()) {
			li.add(it.next());
		}
		return li;
	}

	@Override
	public Customer findCustomerEmailAndPassword(String custEmail, String custPassword) {
		// TODO Auto-generated method stub
		return customerRepository.findByCustEmailAndCustPassword(custEmail, custPassword);
	}

	@Override
	public Customer findCustomerEmail(String custEmail) {
		// TODO Auto-generated method stub
		return customerRepository.findByCustEmail(custEmail);
	}

	@Override
	public String modifyCustStatusToFalse(long custId) {
		customerRepository.updateCustStatusToTrue(false, custId);
		return "Success";
	}
	
	@Override
	public String modifyCustStatusToTrue(long custId) {
		customerRepository.updateCustStatusToFalse(true, custId);
		return "Success";
	}

	@Override
	public void addRefund(double refund, long custId) {
		customerRepository.insertRefund(refund, custId);
		
	}

}
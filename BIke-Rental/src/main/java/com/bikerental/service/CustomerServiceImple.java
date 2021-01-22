package com.bikerental.service;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bikerental.model.Customer;
import com.bikerental.repository.CustomerRepository;



import javax.servlet.ServletContext;




@Service
public class CustomerServiceImple implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private CommonUtilService util;

	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public void removeCustomer(long id) {
		customerRepository.deleteById(id);
		
	}

	@Override
	public Customer getCustomer(long id) {
		Optional<Customer> opt = customerRepository.findById(id);
		return opt.get();
	}
	
	//test image
//	@Override
//	public Customer getCustomer(long id) {
//		Optional<Customer> opt = customerRepository.findById(id);
//		Customer cust = opt.get();
//		System.out.println(cust.getFileName());
//		System.out.println(cust.getCustFname());
//		cust.setFileName(util.fetchImage(cust.getFileName()));
//		//cust.setFileName(util.fetchImage("Events_1611261270472.jpg"));
//		
//		return cust;
//	}
	

	@Override
	public Customer modifyCustomer(Customer customer) {
		
//		Customer custObj = customerRepository.findByCustEmail(customer.getCustEmail());
//		if( custObj != null ) {
//			throw new Exception("Email-Id already exists");
//		}
		
		return customerRepository.save(customer);
		
	}

	@Override
	public List<Customer> getAll() {
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
		return customerRepository.findByCustEmailAndCustPassword(custEmail, custPassword);
	}

	@Override
	public Customer findCustomerEmail(String custEmail) {
		return customerRepository.findByCustEmail(custEmail);
	}

	@Override
	public String modifyCustStatusToFalse(long custId) {
		customerRepository.updateCustStatusToFalse(false, custId);
		return "Success";
	}
	
	@Override
	public String modifyCustStatusToTrue(long custId) {
		customerRepository.updateCustStatusToTrue(true, custId);
		return "Success";
	}

	@Override
	public void addRefund(double refund, long custId) {
		customerRepository.insertRefund(refund, custId);
		
	}
	
	@Override
	public String encoder(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(password);
		return encodedPassword;	
	}
	
	@Override
	public boolean decoder(String password, String encoded) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		boolean isPasswordMatch = passwordEncoder.matches(password, encoded);
		return isPasswordMatch;
	}


}
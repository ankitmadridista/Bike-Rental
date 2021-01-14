package com.bikerental.cntr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bikerental.model.Bike;
import com.bikerental.model.Customer;
import com.bikerental.service.BikeService;
import com.bikerental.service.BookingService;
import com.bikerental.service.CustomerService;

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")

public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	@Autowired
	private BikeService bikeService;
	@Autowired
	private BookingService bookingService;
	
	@PostMapping(value = "customer")
	public Customer addCust(@RequestBody Customer customer) throws Exception {
		String tempEmail = customer.getCustEmail();
		System.out.println("email: "+tempEmail);
		if( tempEmail != null && !"".equals(tempEmail)) {
			Customer customerObj = customerService.findCustomerEmail(tempEmail);
			if( customerObj != null ) {
				throw new Exception("Email " + tempEmail + " already exists" );
			}					
		}
		else {
			throw new Exception("null email");
		}
		return customerService.addCustomer(customer);		
	}
	

	@GetMapping(value = "customer")
	public List<Customer> custList(){
		return customerService.getAll();
	}
	
	@DeleteMapping(value = "customer/{id}")
	public String custDelete(@PathVariable long id) {
		customerService.removeCustomer(id);
		return "success";
	}
	
	@GetMapping(value = "customer/{id}")
	public Customer getCust(@PathVariable long id) {
		return customerService.getCustomer(id);
	
	}
	

	@PutMapping(value = "customer")
	public String custUpdate(@RequestBody Customer customer) {
		customerService.modifyCustomer(customer);	
		return "success";
	}
	

	@PostMapping(value = "customer-check")
	@CrossOrigin(origins = "*")
	public Customer checkProv(@RequestBody Customer customer) throws Exception {
		String email = customer.getCustEmail();
		String password = customer.getCustPassword();
		Customer custObj = null;
		if( email != null && password != null ) {
			custObj = customerService.findCustomerEmailAndPassword(email, password);
		}
		if( custObj == null ) {
			throw new Exception("Invalid Credentials");
		}
		return custObj;		 
	}
	
	@GetMapping(value = "customer-bikes")
	public List<Bike> custBikesList(){
		String status = "Available";
		return bikeService.getAllBikesByStatus(status);
	}
	
	
	


}
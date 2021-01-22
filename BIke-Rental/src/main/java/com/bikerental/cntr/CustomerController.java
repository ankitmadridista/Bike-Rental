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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bikerental.model.Bike;
import com.bikerental.model.Customer;
import com.bikerental.service.BikeService;
import com.bikerental.service.CommonUtilService;
import com.bikerental.service.CustomerService;
import com.bikerental.service.SendEmailService;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	private SendEmailService sendEmailService;
	@Autowired
	private CommonUtilService util;
	
	@PostMapping(value = "customer")
	public Customer addCust(@RequestBody Customer customer) throws Exception {
		String tempEmail = customer.getCustEmail();
		System.out.println("email: "+tempEmail);
		
		String pwd = customer.getCustPassword();
		
		customer.setCustPassword(customerService.encoder(pwd));
		System.out.println(customer.getCustPassword());
		
		if( tempEmail != null && !"".equals(tempEmail)) {
			Customer customerObj = customerService.findCustomerEmail(tempEmail);
			
			if( customerObj != null ) {
				throw new Exception("Email " + tempEmail + " already exists" );
			}					
		}
		else {
			throw new Exception("null email");
		}
		
		String to = customer.getCustEmail();
		String body = "Thanx ...!!! " + customer.getCustFname() + " You have successfully registered with us.";
		String topic = "Registration successfull";
		
		sendEmailService.sendEmail(to, body, topic);
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
	public Customer custUpdate(@RequestBody Customer customer) throws Exception {
			
		return customerService.modifyCustomer(customer);
	}

//	@PutMapping(value = "customer")
//	public Customer custUpdate(@RequestParam String customer, @RequestParam MultipartFile image) throws Exception {
//		
//		Customer cust = new ObjectMapper().readValue(customer, Customer.class);
//		System.out.println(cust.getCustFname());
//		String fileName = util.saveImage(image);
//		cust.setFileName(fileName);
//		
//		return customerService.modifyCustomer(cust);
//	}
	

	@PostMapping(value = "customer-check")
	@CrossOrigin(origins = "*")
	public Customer checkProv(@RequestBody Customer customer) throws Exception {
		String email = customer.getCustEmail();
		String password = customer.getCustPassword();
//		String pwdEncode = customerService.encoder(password);
//		System.out.println(pwdEncode);
		Customer custObj = null;
		if( email != null && password != null ) {
			custObj = customerService.findCustomerEmail(email);
		}
		if( !customerService.decoder(password, custObj.getCustPassword()) || custObj == null ) {
			throw new Exception("Invalid Credentials");
		}
		return custObj;		 
		
	}
	
	@GetMapping(value = "customer-bikes")
	public List<Bike> custBikesList(){
		String status = "Available";
		return bikeService.getAllBikesByStatus(status);
	}
	
	@PostMapping(value = "cust-link-mail")
	public Customer sendLinkOnMail(@RequestBody Customer customer) throws Exception {
		System.out.println(customer.getCustEmail());
		Customer custObj = customerService.findCustomerEmail(customer.getCustEmail());
		if( custObj == null ) {
			throw new Exception("Email Id is not valid");
		}
		
		String to = custObj.getCustEmail();
		String body = "Hello ...!!! " + custObj.getCustFname() + " click on this link to set a new password http://localhost:4200/cust-reset-pass-form" ;
		String topic = "Reset Password";
		
		sendEmailService.sendEmail(to, body, topic);		
		return custObj;	 
	}
	
	
	@PostMapping(value = "cust-reset-pass")
	public Customer resetPassword(@RequestBody Customer customer) throws Exception {
		
		System.out.println(customer.getCustEmail());
		String email = customer.getCustEmail();
		String password = customer.getCustPassword();		
		
		Customer custObj = customerService.findCustomerEmail(email);
		if( custObj == null ) {
			throw new Exception("Invalid Email Id");		
		}
		
		String encPassword = customerService.encoder(password);
		
		if( email != null && password != null )
			custObj.setCustPassword(encPassword);
		
		customerService.modifyCustomer(custObj);;
		return custObj;
	}
	
	
}
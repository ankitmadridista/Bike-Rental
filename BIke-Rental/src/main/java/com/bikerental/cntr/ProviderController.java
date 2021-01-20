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

import com.bikerental.model.Booking;
import com.bikerental.model.Provider;
import com.bikerental.service.BikeService;
import com.bikerental.service.BookingService;
import com.bikerental.service.ProviderService;
import com.bikerental.service.SendEmailService;

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ProviderController {
	
	@Autowired
	private ProviderService providerService;
	
	@Autowired
	private BikeService bikeService;
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private SendEmailService sendEmailService;
	
	@PostMapping(value = "providers")
	public Provider addProv(@RequestBody Provider provider) throws Exception {
		//System.out.println("DOB: " + provider.getProvDateOfBirth());
		String tempEmail = provider.getProvEmail();
		System.out.println("email: "+tempEmail);
		
		String pwd = provider.getProvPassword();
		
		provider.setProvPassword(providerService.encoder(pwd));
		System.out.println(provider.getProvPassword());
		
		if( tempEmail != null && !"".equals(tempEmail)) {
			Provider providerObj = providerService.findProviderEmail(tempEmail);
			if( providerObj != null ) {
				throw new Exception("Email " + tempEmail + " already exists" );
			}					
		}
		else {
			throw new Exception("null email");
		}
		
		String to = provider.getProvEmail();
		String body = "Thanx ...!!! " + provider.getProvFname() + " You have successfully registered with us.";
		String topic = "Registration successfull";
		
		sendEmailService.sendEmail(to, body, topic);
		
		return providerService.addProvider(provider);		
	}

	@GetMapping(value = "providers")
	public List<Provider> provList(){
		return providerService.getAll();
	}
	
	@DeleteMapping(value = "providers/{id}")
	public String provDelete(@PathVariable long id) {
		bikeService.removeBikeByProvId(id);
		providerService.removeProvider(id);
		return "success";
	}
	@CrossOrigin(origins = "*")
	@GetMapping(value = "providers/{id}")
	public Provider getProv(@PathVariable long id) {
		return providerService.getProvider(id);
	
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping(value = "providers")
	public Provider provUpdate(@RequestBody Provider provider) throws Exception {
		
		return providerService.modifyProvider(provider);
	}
	
	//prov login
	@PostMapping(value = "providers-check")
	@CrossOrigin(origins = "*")
	public Provider checkProv(@RequestBody Provider provider) throws Exception {
		String email = provider.getProvEmail();
		String password = provider.getProvPassword();
		String pwdEncode = providerService.encoder(password);
		System.out.println(pwdEncode);
		Provider provObj = null;
		if( email != null && password != null ) {
			provObj = providerService.findProviderEmail(email);
		}
		if( !providerService.decoder(password, provObj.getProvPassword()) || provObj == null ) {
			throw new Exception("Invalid Credentials");
		}
		return provObj;		 
	}
	
	
	//get all bookings by provId
	@GetMapping(value="prov-booking-provId/{provId}")
	public List<Booking> getprovBooking(@PathVariable long provId){
		return bookingService.getByProvId(provId);
	} 
	
	//get all bookings by bikeId
	@GetMapping(value = "prov-booking-bikeId/{bikeId}")
	public List<Booking> getBikeBooking(@PathVariable long bikeId){
		return bookingService.getByCustId(bikeId);
	}
	
	@PostMapping(value = "prov-link-mail")
	public Provider sendLinkOnMail(@RequestBody Provider provider) throws Exception {
		System.out.println(provider.getProvEmail());
		Provider provObj = providerService.findProviderEmail(provider.getProvEmail());
		if( provObj == null ) {
			throw new Exception("Email Id is not valid");
		}
		
		String to = provObj.getProvEmail();
		String body = "Hello ...!!! " + provObj.getProvFname() + " click on this link to set a new password http://localhost:4200/prov-reset-pass-form" ;
		String topic = "Reset Password";
		
		sendEmailService.sendEmail(to, body, topic);
		
		return provObj;	 
	}
	
	
	@PostMapping(value = "prov-reset-pass")
	public Provider resetPassword(@RequestBody Provider provider) throws Exception {
		
		System.out.println(provider.getProvEmail());
		String email = provider.getProvEmail();
		String password = provider.getProvPassword();		
		
		Provider provObj = providerService.findProviderEmail(email);
		if( provObj == null ) {
			throw new Exception("Invalid Email Id");		
		}
		
		String encPassword = providerService.encoder(password);
		
		if( email != null && password != null )
			provObj.setProvPassword(encPassword);
		
		providerService.modifyProvider(provObj);
		return provObj;
	}
}

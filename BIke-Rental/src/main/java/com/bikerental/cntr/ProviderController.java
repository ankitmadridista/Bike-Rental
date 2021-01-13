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

import com.bikerental.model.Provider;
import com.bikerental.service.BikeService;
import com.bikerental.service.ProviderService;

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ProviderController {
	
	@Autowired
	private ProviderService providerService;
	
	@Autowired
	private BikeService bikeService;
	
	@PostMapping(value = "providers")
	public Provider addProv(@RequestBody Provider provider) throws Exception {
		System.out.println("DOB: " + provider.getProvDateOfBirth());
		String tempEmail = provider.getProvEmail();
		System.out.println("email: "+tempEmail);
		if( tempEmail != null && !"".equals(tempEmail)) {
			Provider providerObj = providerService.findProviderEmail(tempEmail);
			if( providerObj != null ) {
				throw new Exception("Email " + tempEmail + " already exists" );
			}					
		}
		else {
			throw new Exception("null email");
		}
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
	public String provUpdate(@RequestBody Provider provider) {
		providerService.modifyProvider(provider);	
		return "success";
	}
	
	@PostMapping(value = "providers-check")
	@CrossOrigin(origins = "*")
	public Provider checkProv(@RequestBody Provider provider) throws Exception {
		String email = provider.getProvEmail();
		String password = provider.getProvPassword();
		Provider provObj = null;
		if( email != null && password != null ) {
			provObj = providerService.findProviderEmailAndPassword(email, password);
		}
		if( provObj == null ) {
			throw new Exception("Invalid Credentials");
		}
		return provObj;		 
	}
}

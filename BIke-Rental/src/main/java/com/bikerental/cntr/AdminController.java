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

import com.bikerental.model.Admin;
import com.bikerental.model.Bike;
import com.bikerental.model.Provider;
import com.bikerental.service.AdminService;
import com.bikerental.service.BikeService;
import com.bikerental.service.BookingService;
import com.bikerental.service.SendEmailService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private BikeService bikeService;
	@Autowired
	private BookingService bookingService;
	@Autowired
	private SendEmailService sendEmailService;
	
	@PostMapping(value = "admin")
	public Admin insertAdmin(@RequestBody Admin admin) throws Exception {
		String tempAdminEmail = admin.getAdminEmail();
		System.out.println(tempAdminEmail);
		String pwd = admin.getAdminPassword();
		
		admin.setAdminPassword(adminService.encoder(pwd));
		System.out.println(admin.getAdminPassword());
		
		if( tempAdminEmail != null && !"".equals(tempAdminEmail)) {
			Admin adminObj = adminService.getByEmail(tempAdminEmail);
			if( adminObj != null ) {
				throw new Exception("Admin with Email : " + tempAdminEmail + " already exists" );
			}					
		}
		else {
			throw new Exception("null");
		}
		
		String to = admin.getAdminEmail();
		String body = "Thanx ...!!! " + admin.getAdminName() + " You have successfully registered with us.";
		String topic = "Registration successfull";
		
		sendEmailService.sendEmail(to, body, topic);
		
		return adminService.addAdmin(admin);		
	}	
	
	@PostMapping(value = "admin-check")
	@CrossOrigin(origins = "*")
	public Admin checkAdmin(@RequestBody Admin admin) throws Exception {
		String email = admin.getAdminEmail();
		String password = admin.getAdminPassword();
		String pwdEncode = adminService.encoder(password);
		System.out.println(pwdEncode);
		Admin adminObj = null;
		if( email != null && password != null ) {
			adminObj = adminService.getByEmail(email);
		}
		if( !adminService.decoder(password, adminObj.getAdminPassword()) || adminObj == null ) {
			throw new Exception("Invalid Credentials");
		}
		return adminObj;		 
	}
	
	@DeleteMapping(value = "admin/{id}")
	public String deleteAdmin(@PathVariable long id) {
		adminService.removeAdmin(id);
		return "success";
	}
	
	@GetMapping(value = "admin/{id}")
	public Admin getAdminById(@PathVariable long id) {
		return adminService.showMyProfile(id);
	
	}
	
	@PutMapping(value = "admin")
	public String updateAdmin(@RequestBody Admin admin) {
		adminService.modifyMyProfile(admin);			
		return "success";
	}
	
	@GetMapping(value = "admin")
	public List<Admin> getAdminList(){
		return adminService.getAllAdmin();
	}
	
	@GetMapping(value = "admin-prov")
	public List<Provider> getProvidersList(){
		return adminService.getAllProvider();
	}
	
	@PutMapping(value = "admin-prov")
	public String updateProvider(@RequestBody Provider provider) {
		adminService.modifyProvider(provider);			
		return "success";
	}
	
	@DeleteMapping(value = "admin-prov/{id}")
	public String deleteProvider(@PathVariable long id) {
		adminService.removeProvider(id);
		return "success";
	}
	
	@GetMapping(value = "admin-bikes")
	public List<Bike> getBikesList(){
		return adminService.getAllBikes();
	}
	
	@GetMapping(value = "admin-bike-status/{status}")
	public List<Bike> getAvailableBikesList(@PathVariable String status){
		return bikeService.getAllBikesByStatus(status);
	}
	
	
}

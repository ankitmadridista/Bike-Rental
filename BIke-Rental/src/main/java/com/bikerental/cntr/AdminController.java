package com.bikerental.cntr;

import java.util.List;

import javax.websocket.server.PathParam;

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
import com.bikerental.model.Booking;
import com.bikerental.model.Provider;
import com.bikerental.repository.BikeRepository;
import com.bikerental.service.AdminService;
import com.bikerental.service.BikeService;
import com.bikerental.service.BookingService;

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
	
	
	@PostMapping(value = "admin")
	public Admin insertAdmin(@RequestBody Admin admin) throws Exception {
		String tempAdminEmail = admin.getAdminEmail();
		//System.out.println("bike no: "+tempBikeNo);
		if( tempAdminEmail != null && !"".equals(tempAdminEmail)) {
			Admin adminObj = adminService.getByEmail(tempAdminEmail);
			if( adminObj != null ) {
				throw new Exception("Admin with Email : " + tempAdminEmail + " already exists" );
			}					
		}
		else {
			throw new Exception("null BikeNo");
		}
		return adminService.addAdmin(admin);		
	}	
	
	@PostMapping(value = "admin-check")
	@CrossOrigin(origins = "*")
	public Admin checkAdmin(@RequestBody Admin admin) throws Exception {
		String email = admin.getAdminEmail();
		String password = admin.getAdminPassword();
		Admin adminObj = null;
		if( email != null && password != null ) {
			adminObj = adminService.findAdminEmailAndPassword(email, password);
		}
		if( adminObj == null ) {
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
	
	@GetMapping(value = "adminProv")
	public List<Provider> getProvidersList(){
		return adminService.getAllProvider();
	}
	
	@PutMapping(value = "adminProv")
	public String updateProvider(@RequestBody Provider provider) {
		adminService.modifyProvider(provider);			
		return "success";
	}
	
	@DeleteMapping(value = "adminProv/{id}")
	public String deleteProvider(@PathVariable long id) {
		adminService.removeProvider(id);
		return "success";
	}
	
	@GetMapping(value = "adminBikes")
	public List<Bike> getBikesList(){
		return adminService.getAllBikes();
	}
	
	@GetMapping(value = "adminBikeByStatus/{status}")
	public List<Bike> getAvailableBikesList(@PathVariable String status){
		return bikeService.getAllBikesByStatus(status);
	}
	
	@GetMapping(value = "adminBooking")
	public List<Booking> getBookingList(){
		return bookingService.getAllBooking();
	}
	
	@GetMapping(value ="custbooking/{custId}")
	public List<Booking> getCustBooking(@PathVariable long custId){
		return bookingService.getByCustId(custId);
	}
	
	@GetMapping(value = "bikeBooking/{bikeId}")
	public List<Booking> getBikeBooking(@PathVariable long bikeId){
		return bookingService.getByCustId(bikeId);
	}
	
	@GetMapping(value="booking/{id}")
	public Booking getBookingDetails(@PathVariable long id){
		return bookingService.getByBookId(id);
	}
	
	@GetMapping(value="provbooking/{provId}")
	public List<Booking> getProvBooking(@PathVariable long provId)
	{
		return bookingService.getByProvId(provId);
	} 
	
	@DeleteMapping(value="deletebooking/{id}")
	public String deleteBooking(@PathVariable long id) {
		bookingService.deleteBooking(id);
		return "Sucess";
	}
	@PutMapping(value="updatebooking")
	public String updateBooking(@RequestBody Booking book) {
		bookingService.modifyBooking(book);
		return "Sucess";
	}
	
}

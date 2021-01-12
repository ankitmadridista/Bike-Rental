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
import com.bikerental.model.Provider;
import com.bikerental.repository.BikeRepository;
import com.bikerental.service.AdminService;
import com.bikerental.service.BikeService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private BikeService bikeService;
	
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
	
	
}

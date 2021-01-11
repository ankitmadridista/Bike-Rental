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
import com.bikerental.service.BikeService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class BikeController {
	
	@Autowired
	private BikeService bikeService;
	
	@PostMapping(value = "bikes")
	public Bike addProv(@RequestBody Bike bike) throws Exception {
		String tempBikeNo = bike.getBikeNo();
		bike.setBikeStatus("Available");
		//System.out.println("bike no: "+tempBikeNo);
		if( tempBikeNo != null && !"".equals(tempBikeNo)) {
			Bike bikeObj = bikeService.getByBikeNo(tempBikeNo);
			if( bikeObj != null ) {
				throw new Exception("Bike with bike No.: " + tempBikeNo + " already exists" );
			}					
		}
		else {
			throw new Exception("null BikeNo");
		}
		return bikeService.addBike(bike);		
	}
	
	@GetMapping(value = "bikes")
	public List<Bike> getBikeList(){
		return bikeService.getAll();
	}
	
	@DeleteMapping(value = "bikes/{id}")
	public String deleteBike(@PathVariable long id) {
		bikeService.removeBike(id);
		return "success";
	}
	
	@GetMapping(value = "bikesByBikeId/{id}")
	public Bike getBikeByBikeId(@PathVariable long id) {
		return bikeService.getBike(id);
	
	}
	
	@GetMapping(value = "bikesByProvId/{id}")
	public List<Bike> getBikeByProvId(@PathVariable long id) {
		return bikeService.getByProvId(id);
	
	}
	
	@PutMapping(value = "bikes")
	public String updateBike(@RequestBody Bike bike) {
		bikeService.modifyBike(bike);	
		return "success";
	}
	
}

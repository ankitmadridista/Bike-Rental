package com.bikerental.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bikerental.model.Admin;
import com.bikerental.model.Bike;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
	public Admin findByAdminEmail(String adminEmail);
	
//	QueryfindAllAvailableBikes
//	@Query("select u from Bike u where u.status = Available")
//	  List<Bike> findAllAvailableBikes();
	
//	public void updateProductDetails(int pid, int spid) {
//		String sql = "update productdetails SET sp_id ="+spid+" WHERE product_id="+pid;
//		System.out.println("SQL "+sql);
//		jdbcTemplate.execute(sql);
//	}
	
}

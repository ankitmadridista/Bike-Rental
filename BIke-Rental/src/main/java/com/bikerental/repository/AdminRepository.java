package com.bikerental.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bikerental.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
	public Admin findByAdminEmail(String adminEmail);
	public Admin findByAdminEmailAndAdminPassword(String adminEmail, String adminPassword);
	
//	QueryfindAllAvailableBikes
//	@Query("select u from Bike u where u.status = Available")
//	  List<Bike> findAllAvailableBikes();
	
//	public void updateProductDetails(int pid, int spid) {
//		String sql = "update productdetails SET sp_id ="+spid+" WHERE product_id="+pid;
//		System.out.println("SQL "+sql);
//		jdbcTemplate.execute(sql);
//	}
	
}

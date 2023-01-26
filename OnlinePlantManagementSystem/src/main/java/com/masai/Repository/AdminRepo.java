package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.model.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer>{
	public Admin findByAdminUsername(String adminUsername);
	
	
}

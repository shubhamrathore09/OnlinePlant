package com.masai.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.model.Customer;
import com.masai.model.CustomerDTO;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{
	
	public Customer findByCustomerUsername(String customerUsername);
	
	@Query("select new com.masai.model.CustomerDTO(c.customerId,c.customerName,c.customerEmail,c.customerUsername,c.address) from Customer c")
	public List<CustomerDTO> getAllCustomer();
}

package com.masai.Service;

import java.util.List;

import com.masai.exception.AdminLoginException;
import com.masai.exception.CustomerException;
import com.masai.model.AdminLoginDTO;
import com.masai.model.Customer;
import com.masai.model.CustomerDTO;

public interface AdminLoginService {
	
    public String adminLoginDTO(AdminLoginDTO admin) throws AdminLoginException;
	
	public String adminLogoutDTO(String key) throws AdminLoginException;
	
	public List<CustomerDTO> viewAllCustomers(String key) throws CustomerException;
	
	public Customer removeCustomerById(Integer customerId, String key) throws AdminLoginException, CustomerException;

}

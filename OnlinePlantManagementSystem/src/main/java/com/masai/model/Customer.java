package com.masai.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	
	@NotEmpty
	@Size(min = 3, message = "Costomer Name should contain 2 or more than 2 latters !!")
	private String customerName;
	
	@NotEmpty
	@Email
	private String customerEmail;
	
	@NotEmpty
	@Pattern(regexp = "^[6789][0-9]{9}")
	private String customerUsername;
	
	@NotEmpty
	@Size(min = 6,message = "password digit should be minimum 6")
	private String customerPassword;

	@Embedded
	private Address address;

}

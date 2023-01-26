package com.masai.model;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {
	

	private Integer addressId;
	private String houseNo;
	private String colony;
	private String city;
	private String state;
	private Integer pincode;

}

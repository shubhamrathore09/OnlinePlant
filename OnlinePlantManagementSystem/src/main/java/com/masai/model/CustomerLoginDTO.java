package com.masai.model;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerLoginDTO {

	@NotNull(message = "username is mandatory")
	private String customerUsername;
	
	@NotEmpty(message = "Please enter password")
	private String customerPassword;
}

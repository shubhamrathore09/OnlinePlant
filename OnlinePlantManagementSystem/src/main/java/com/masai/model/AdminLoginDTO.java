package com.masai.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminLoginDTO {
	
	@NotNull(message = "username should be mandatory")
	@Pattern(regexp = "^[6789][0-9]{9}")
	private String adminUsername;
	
	@NotNull(message = "password should be mandatory")
	@Size(min = 6,message = "password digit should be minimum 6")
	private String adminPassword;

}

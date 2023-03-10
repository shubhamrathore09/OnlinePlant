package com.masai.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
	

	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private Integer adminId;
	@Pattern(regexp = "^[6789][0-9]{9}")
	private String adminUsername;
	@NotNull
	@Size(min = 6,message = "password digit should be minimum 6")
	private String adminPassword;

}

package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Seed {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer seedId;
	
	@NotBlank(message = "Seed Name is Mandatory")
	private String commanName;
	
	@NotBlank(message = "Bloom Time is Mandatory")
	private String bloomTime;
	
	@NotBlank(message = "Watering is Mandatory")
	private String watering;
	
	
	@NotBlank(message = "Temparature is Mandatory")
	private String temparature;
	
	@NotBlank(message = "TypeOfSeed is Mandatory")
	private String typeOfSeed;
	
	@NotBlank(message = "Seed Description is Mandatory")
	private String seedDescription;
	
	@NotNull(message = "stock value can not be null")
//	@Min(value =  0,message = "stock value must be greater than equal to 0")
	private Integer seedStock;
	
	@NotNull(message = "Seed Cost should not be null")
//	@Min(value = 1 , message = "stock value must be greater than equal to 1")
	private Double seedsCost;
	
	@NotNull(message = "Seed Per Packed should not be null")
	private Integer seedPerPacked;



}

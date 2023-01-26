package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Planter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer planterId;
	
//	@NotNull(message = "Planter height should not be null")
//	@Min(value = 1, message = "Planter height is must be greater than equal to 1")
	private float planterheight;
	
	
	
//	@NotNull(message = "Planter Color should not be null")
	private String planterColor;
	
//	@NotNull(message = "Planter Shape should not be null")
	private String planterShape;
	
//	@NotNull(message = "Planter Stock should not be null")
//	@Min(value = 1, message = "Planter stock is must be greater than equal to 1")
	private Integer planterStock;
	
//	@NotNull(message = "Planter Cost should not be null")
//	@Min(value = 1, message = "Planter cost is must be greater than equal to 1")
	private Double planterCost;
	  
	@JsonIgnore
	@OneToOne(cascade =  CascadeType.ALL)
	private Seed seed;

	@JsonIgnore
	@OneToOne(cascade =  CascadeType.ALL)
	private Plant plant;


	
	
	

}

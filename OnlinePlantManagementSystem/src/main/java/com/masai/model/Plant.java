package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Plant {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Integer plantId;

	    @NotNull(message = "Plant height can not be null")
	    @Min(value = 1, message = "Planter height is must be greater than equal to 1")
	    private Integer plantHeight;
	    
	    
	    @NotBlank(message = "Plant name can not be blank")
	    private String commonName;
	    
	    @NotBlank(message = "BloomTime can not be blank")
	    private String bloomTime;
	    
	    @NotNull
	    private String temperature;
	    
	    @NotBlank(message = "TypeOfPlant can not be blank")
	    private String typeOfPlant;
	    
	    @NotNull(message = "Plant Description can not be null")
	    private String plantDescription;
	    
	    @NotNull(message = "Plant Stock can not be null")
	    @Min(value = 1, message = "Planter height is must be greater than equal to 1")
	    private Integer plantsStock;
	    
	    @NotNull(message = "plant cost can not be null")
	    @Min(value = 1, message = "Planter height is must be greater than equal to 1")
	    private Double plantCost;
	    
	

}

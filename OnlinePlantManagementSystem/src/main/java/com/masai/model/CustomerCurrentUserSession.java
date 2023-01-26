package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerCurrentUserSession {
	
	@Id
	private Integer customerId;
	
	private String customerUuid;
	
	private LocalDateTime localDateTime;

}

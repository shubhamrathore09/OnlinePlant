package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AdminCurrentUserSession {

	@Id
	@Column(unique = true)
	private Integer adminId;
	
	private String adminUuid;
	
	private LocalDateTime localDateTime;
	
	
}

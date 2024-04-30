package com.suyad.binding;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
public class CitizenApp 
{
	private Integer caseNum;
	
	private String citizenName;
	
	private String citizenEmail;
	
	private String citizenGender;
	
	private Long citizenPhno;
	
	private LocalDate citizenDob;
	
	private Long citizenSsn;
	
	private LocalDate createdDate;

	private LocalDate updatedDate;
	
	private String createdBy;
}

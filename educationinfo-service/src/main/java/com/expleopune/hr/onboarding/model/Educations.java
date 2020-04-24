package com.expleopune.hr.onboarding.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "education_info")
public class Educations extends AuditModel<String>{
	
	@Id
	@GeneratedValue
	private long eduId;
	
	private String nameAddrSchoolCollgeInst;
	
	private String nameAddrBoardUnivrstyAffiltd;
	
	private String typeOfDgreeDiploma;
	
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private String frmDate;
	
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private String toDate;
	
	private String rollRegExamSeatNum;
	

}

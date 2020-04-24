package com.expleopune.hr.onboarding.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name="family_info")
@EntityListeners(AuditingEntityListener.class)
public class Family extends AuditModel<String> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "family_id")
	private Long familyId;
	
	@Column(name = "logIn_userId", nullable = false)
	private String usrId;
	
	@Column(name = "father_in_law_name")
	private String fatherInLawNam;
	
	@Column(name = "father_in_law_DOB")
	private String fatherInLawDOB;
	
	@Column(name = "mother_in_law_name")
	private String motherInLawNam;
	
	@Column(name = "mother_in_law_DOB")
	private String motherInLawDOB;
	
	@Column(name = "spouse_name")
	private String spouseNam;
	
	@Column(name = "spouse_DOB")
	private String spouseDOB;
	
	@Column(name = "child1_name")
	private String child1Nam;
	
	@Column(name = "child1_DOB")
	private String child1DOB;
	
	@Column(name = "child2_name")
	private String child2Nam;
	
	@Column(name = "child2_DOB")
	private String child2DOB;
	
	
}

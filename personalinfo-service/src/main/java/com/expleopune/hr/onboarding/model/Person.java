package com.expleopune.hr.onboarding.model;

import java.time.*;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.expleopune.hr.onboarding.model.BankAccount.SecondaryBankAccount;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "personal_info")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {
	
	//DateTimeFormatter f = DateTimeFormatter.ofPattern("MM dd yyyy");
	
	
	@Id
	@GeneratedValue
	@Column(name = "newJoineeId")
	private long id;
	
	private String fName;
	
	private String mName;
	
	private String lName;
	
	private String gender;
	
	@Column(name = "phone1")
	String mobileNumber1;
	
	@Column(name = "phone2")
	String mobileNumber2;
	
	@Column(name = "DOB")
	private String birthDate;
	
	
	private String aadharUID;
	
	private String pfUAN;
	
	private String panNum;
	
	private String passportNum;
	
	@Column(name = "passportIssue")
	private String passportIssueDate;
	
	@Column(name = "passportExpiry")
	private String passportExpiryDate;
	
	private String bloodGrp;
	
	private String martialStatus;
	
	@Column(name = "anniversary")
	private String anniversaryDate;
	
	private String emailAddr;
	
	@Embedded
	Address presentAddress;
	
	@Embedded
	BankAccount primayBankAccount;
	
}

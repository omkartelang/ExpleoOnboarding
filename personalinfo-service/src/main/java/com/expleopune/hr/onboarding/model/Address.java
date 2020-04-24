package com.expleopune.hr.onboarding.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import com.expleopune.hr.onboarding.model.BankAccount.SecondaryBankAccount;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

	/////////////// Present Address ///////////////////////////////////////
	@Column(name = "Pres_streetAddr")
	private String streetAddr;
	
	@Column(name = "Pres_streetAddrLine2")
	private String streetAddrLine2;
	
	@Column(name = "Pres_city")
	private String city;
	
	@Column(name = "Pres_state")
	private String state;
	
	@Column(name = "Pres_pinCode")
	private long pinCode;
	
	@Column(name = "Pres_country")
	private String country;
	
	@Embedded
	PermanentAddr permanentAddr;
	
	@Embeddable
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class PermanentAddr
	{
		/////////////// Permanent Address ///////////////////////////////////////
		@Column(name = "Perm_country")
		private String streetAddr;
		
		@Column(name = "Perm_streetAddrLine2")
		private String streetAddrLine2;
		
		@Column(name = "Perm_city")
		private String city;
		
		@Column(name = "Perm_state")
		private String state;
		
		@Column(name = "Perm_pinCode")
		private long pinCode;
		
		@Column(name = "Perm_cntry")
		private String country;
		
	}
	
	
}

package com.expleopune.hr.onboarding.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccount {

	///////////////////Primary bank account details ////////////////////////
	@Column(name = "Prim_bankName")
	private String bankName;
	
	@Column(name = "Prim_branchName")
	private String branchName;
	
	@Column(name = "Prim_bankAcctNum")
	private long bankAcctNum;
	
	@Embedded
	SecondaryBankAccount secondaryBankAccoutn;
	
	@Embeddable
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class SecondaryBankAccount
	{
		@Column(name = "Secdry_bankName")
		private String bankName;
		
		@Column(name = "Secdry_branchName")
		private String branchName;
		
		@Column(name = "Secdry_bankAcctNum")
		private long bankAcctNum;
	}
}

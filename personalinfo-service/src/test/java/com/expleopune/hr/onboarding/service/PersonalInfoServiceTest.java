package com.expleopune.hr.onboarding.service;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.expleopune.hr.onboarding.model.Address;
import com.expleopune.hr.onboarding.model.BankAccount;
import com.expleopune.hr.onboarding.model.Person;
import com.expleopune.hr.onboarding.repository.PersonalInfoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.expleopune.hr.onboarding.model.Address.PermanentAddr;
import com.expleopune.hr.onboarding.model.BankAccount.SecondaryBankAccount;

@SpringBootApplication
class PersonalInfoServiceTest {
	
	private PersonalInfoService personalInfoService;
	
	 @BeforeEach
	    public void setup(){
		 	personalInfoService = new PersonalInfoService();
		 	personalInfoService.personalInfoRepository = Mockito.mock(PersonalInfoRepository.class);
	    }
	
	
	@Test
	void test() throws JsonProcessingException {
		PermanentAddr permanentAddr = PermanentAddr.builder()
				.city("Nanded")
				.country("India")
				.pinCode(431734)
				.state("Maharashtra")
				.streetAddr("Vakil Colony")
				.streetAddrLine2("Kandhar")
				.build();


		Address address = Address.builder()
						.city("Pune")
						.country("India")
						.pinCode(411014)
						.state("Maharashtra")
						.streetAddr("Ashatvinayak nagar")
						.streetAddrLine2("opp. Agarwal Hospital")
						.permanentAddr(permanentAddr)
						.build();
		
		SecondaryBankAccount secondaryBankAccoutn = SecondaryBankAccount.builder()
						.bankName("sbi bank")
						.bankAcctNum(7654321)
						.branchName("chandannagar")
						.build();
				
		BankAccount bankAccount = BankAccount.builder()
						.bankName("icici bank")
						.bankAcctNum(1234567)
						.branchName("Aundh")
						.secondaryBankAccoutn(secondaryBankAccoutn)
						.build();
		
		Person person = Person.builder()
						.fName("Omkar")
						.mName("Sambhaji")
						.lName("Telang")
						.aadharUID("1230970as")
						.presentAddress(address)
						.anniversaryDate("20-10-2010")
						.birthDate("28-10-1981")
						.bloodGrp("O=ve")
						.emailAddr("omakar.telang@expleogroup.com")
						.gender("Male")
						.martialStatus("Married")
						.mobileNumber1("9673330142")
						.mobileNumber2("1234567890")
						.panNum("1234a")
						.passportExpiryDate("20-10-2010")
						.passportIssueDate("20-10-2020")
						.passportNum("122334556aaaaa")
						.pfUAN("12wwwwwwwww")
						.primayBankAccount(bankAccount)
						.build();
			Mockito.when(personalInfoService.personalInfoRepository.save(Mockito.any())).thenReturn(new Person());
		
			boolean added = personalInfoService.addPersonalInfo(person);
		
			Assertions.assertThat(added).isTrue();
			
			ObjectMapper objectMapper = new ObjectMapper();
			String valueString = objectMapper.writeValueAsString(person);

		System.out.println(valueString);
	}

}

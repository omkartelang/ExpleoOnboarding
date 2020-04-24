package com.expleopune.hr.onboarding.service;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.expleopune.hr.onboarding.model.EmpExpInfo;
import com.expleopune.hr.onboarding.repository.EmpExpRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class EmpExpServiceTest {

	EmpExpService empExpService;
	
	@BeforeEach
	void setUp()
	{
		empExpService = new EmpExpService();
		
		empExpService.empExpRepository = Mockito.mock(EmpExpRepository.class);
	}
	
	@Test
	void testAddEmpExp() throws JsonProcessingException {
		
		EmpExpInfo empExpInfo = EmpExpInfo.builder()
				.usrId("otelang")
				.empId("512345A")
				.nameOfComp("Expleo Pvt. Ltd. Pune")
				.grade("GG4")
				.jobTitle("Sr. Technical Engg")
				.hrPersonContact("1234567890")
				.hrPersonEmail("test@gmail.com")
				.hrPersonNam("Rajeev Kumar")
				.mngrNam("Sachin")
				.mngrSuprEmail("sachin@gmail.com")
				.reasonForLeaving("looking for good package")
				.salaryInCTCPerAnnum(600000.00)
				.salaryInGrossPerMonth(45000.00)
				.state("Maharashtra")
				.city("Pune")
				.addrOfCmp("Hinjewadi Phae3")
				.frmDate("08-10-2010")
				.toDate("08-09-2019")
				.build();
		
		Mockito.when(empExpService.empExpRepository.save(Mockito.any())).thenReturn(new EmpExpInfo());
		
		boolean saved = empExpService.addEmpExp(empExpInfo);
		
		Assertions.assertThat(saved).isTrue();
		
		ObjectMapper objectMapper = new ObjectMapper();
		String valueString = objectMapper.writeValueAsString(empExpInfo);
		
		System.out.println(valueString);
	}

	@Test
	void testUpdateEmpExp() {
		
	}

	@Test
	void testFetchAllEmpExpInfo() {
		
	}

}

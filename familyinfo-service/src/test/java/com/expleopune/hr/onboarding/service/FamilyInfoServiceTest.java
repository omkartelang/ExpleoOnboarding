package com.expleopune.hr.onboarding.service;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.expleopune.hr.onboarding.FamilyinfoServiceApplication;
import com.expleopune.hr.onboarding.model.Family;
import com.expleopune.hr.onboarding.repository.FamilyRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
class FamilyInfoServiceTest {
	
	FamilyInfoService familyInfoService;
	
	@BeforeEach
	void setUp()
	{
		familyInfoService = new FamilyInfoService();
		familyInfoService.familyRespository = Mockito.mock(FamilyRepository.class);
	}

	@Test
	void testAddFamily() throws JsonProcessingException {
		Family family = Family.builder()
				.fatherInLawNam("Rajesh Kumar")
				.fatherInLawDOB("28-10-1070")
				.motherInLawNam("Priyanka Kumar")
				.motherInLawDOB("10-10-75")
				.spouseNam("Amruta Kumar")
				.spouseDOB("11-11-1983")
				.child1Nam("Vipul shah")
				.child1DOB("20-12-2010")
				.child2Nam("Arun Shah")
				.child2DOB("12-09-2015")
				.usrId("test123")
				.build();
		
		Mockito.when(familyInfoService.familyRespository.save(Mockito.any())).thenReturn(new Family());
		
		boolean saved = familyInfoService.addFamily(family);
		
		Assertions.assertThat(saved).isTrue();
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		String valueAsString = objectMapper.writeValueAsString(family);
		
		System.out.println(valueAsString);
	}

}

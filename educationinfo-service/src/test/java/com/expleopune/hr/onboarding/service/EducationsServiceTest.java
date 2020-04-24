package com.expleopune.hr.onboarding.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import com.expleopune.hr.onboarding.model.Educations;
import com.expleopune.hr.onboarding.repository.EducationInfoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class EducationsServiceTest {

	//@Autowired
	EducationsService educationsService;
	
	@BeforeEach
	void setUp()
	{
		educationsService = new EducationsService();
		educationsService.educationInfoRepository = Mockito.mock(EducationInfoRepository.class);
	}
	
	@Test
	void testAddEduDetails() throws JsonProcessingException {
		Educations educations = Educations.builder()
				.nameAddrSchoolCollgeInst("Shri Tuljabhavani College Tuljapur")
				.nameAddrBoardUnivrstyAffiltd("Dr. B. A. M. University Augrangabad")
				.typeOfDgreeDiploma("B.E.")
				.frmDate("2010-01-04")
				.toDate("2015-01-04")
				.rollRegExamSeatNum("1234fffff")
				.build();
		
		Mockito.when(educationsService.educationInfoRepository.save(Mockito.any())).thenReturn(new Educations());
		
		boolean saved = educationsService.addEduDetails(educations);
		
		System.out.println(educations);
		
		Assertions.assertThat(saved).isTrue();
		
		ObjectMapper objectMapper = new ObjectMapper();
		String valueString = objectMapper.writeValueAsString(educations);
		
		System.out.println(valueString);
	}

	@Test
	void testUpdateEduInfo() {
		
	}

	@Test
	void testGetEduInfo() {
		
	}

}

package com.expleopune.hr.onboarding.controller.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.expleopune.hr.onboarding.controller.repository.ProfRefRepository;
import com.expleopune.hr.onboarding.model.ProfRef;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class ProfRefServiceTest {

	ProfRefService profRefService;
	
	@BeforeEach
	void setUp()
	{
		profRefService = new ProfRefService();
		profRefService.profRefRepository = Mockito.mock(ProfRefRepository.class);
	}
	
	@Test
	void testAddProfRef() throws JsonProcessingException {
		ProfRef profRef = ProfRef.builder()
				.personNam("Sachin Chavan")
				.emailAddr("sachintest@gmail.com")
				.usrId("profRefUsr")
				.build();
		
		Mockito.when(profRefService.profRefRepository.save(Mockito.any())).thenReturn(new ProfRef());
		
		boolean saved = profRefService.addProfRef(profRef);
		
		Assertions.assertThat(saved).isTrue();
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		String valueAsString = objectMapper.writeValueAsString(profRef);
		
		System.out.println(valueAsString);
	}

}

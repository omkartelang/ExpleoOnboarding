package com.expleopune.hr.onboarding.controller;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.expleopune.hr.onboarding.model.Family;
import com.expleopune.hr.onboarding.repository.FamilyRepository;
import com.expleopune.hr.onboarding.service.FamilyInfoService;

class FamilyControllerTest {

	
	FamilyController familyController;
	
	
	@BeforeEach
	void setUp()
	{
		//familyInfoService = new FamilyInfoService();
		familyController = new FamilyController();
		familyController.familyInfoService = Mockito.mock(FamilyInfoService.class);
	}
	
	
	@Test
	void testPostFamilyInfo() {
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
         
        //when(familyInfoService.addFamily(Mockito.any())).thenReturn(true);
        
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
        
		when(familyController.familyInfoService.addFamily(Mockito.any())).thenReturn(true);
		
		ResponseEntity<Boolean> responseEntity = familyController.postFamilyInfo(family);
		
		Assertions.assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
		//Assertions.assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");
		
		System.out.println(responseEntity.getHeaders().getLocation().getPath());
	}

	/*@Test
	void testModifyFamilyInfo() {
		fail("Not yet implemented");
	}

	@Test
	void testReturnFamilyInfo() {
		fail("Not yet implemented");
	}*/

}

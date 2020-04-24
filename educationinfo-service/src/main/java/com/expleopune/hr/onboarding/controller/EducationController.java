package com.expleopune.hr.onboarding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expleopune.hr.onboarding.model.Educations;
import com.expleopune.hr.onboarding.service.EducationsService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping(value = "api/educationinfo-service")
public class EducationController {

	@Autowired
	EducationsService educatonsService;
	
	@PostMapping
	public ResponseEntity <Boolean> addEduDetails(@RequestBody Educations educaitons)
	{
		boolean saved = educatonsService.addEduDetails(educaitons);
		return ResponseEntity.ok(saved);
	}
	
	
	@GetMapping
    public ResponseEntity<String> getEducationsInfo(long eduId) throws JsonProcessingException
    {
    	String getString = educatonsService.getEduInfo(eduId);
    	
    	return ResponseEntity.ok().body(getString);
    }
    
    @PutMapping
    public ResponseEntity<Boolean> updateEducationInfo( long eduId,@RequestBody Educations educaitons )
    { 
    	boolean updated = educatonsService.updateEduInfo(eduId, educaitons );
		return ResponseEntity.ok(updated);
    	
    }
}

package com.expleopune.hr.onboarding.controller;

import javax.persistence.PostUpdate;
import javax.persistence.PreUpdate;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.expleopune.hr.onboarding.model.Person;
import com.expleopune.hr.onboarding.service.PersonalInfoService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping(value = "api/personalinfo-service")
public class PersonalInfoController {
	
	@Autowired
    PersonalInfoService personalInfoService;

    @PostMapping
    public ResponseEntity<Boolean> Add(@RequestBody Person person){
        boolean added = personalInfoService.addPersonalInfo(person);
        return ResponseEntity.ok(added);
    }
    
    @GetMapping
    public ResponseEntity<String> getPersonalInfo(long id) throws JsonProcessingException
    {
    	String getString = personalInfoService.getPersonalInfo(id);
    	
    	return ResponseEntity.ok().body(getString);
    }
    
    @PutMapping
    public ResponseEntity<Boolean> update( long id,@RequestBody Person person )
    { 
    	boolean updated = personalInfoService.updatePersonalInfo(id, person );
		return ResponseEntity.ok(updated);
    	
    }

}

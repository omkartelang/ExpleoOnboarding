package com.expleopune.hr.onboarding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.expleopune.hr.onboarding.model.Family;
import com.expleopune.hr.onboarding.service.FamilyInfoService;

@RestController
@RequestMapping(value = "api/familyinfo-service")
public class FamilyController {
	
	@Autowired
	public FamilyInfoService familyInfoService;
	
	
	@PostMapping
	public ResponseEntity<Boolean> postFamilyInfo(@RequestBody Family family){
		
		boolean posted = familyInfoService.addFamily(family);
		
		System.out.println(posted);
		
		return ResponseEntity.ok(posted);		
	}
	
	@PutMapping//("/{familyId}/{usrId}")
	public ResponseEntity<Boolean> modifyFamilyInfo(@RequestBody Family family, 
			@RequestParam(name = "familyId",required = true) Long familyId, @RequestParam(name = "usrId",required = true) String usrId){
		
		boolean modified = familyInfoService.updateFamily(familyId, usrId, family);
		
		return ResponseEntity.ok(modified);
	}
	
	@GetMapping //("/{usrId}")
	public  ResponseEntity<List<Family>> returnFamilyInfo(@RequestParam(name = "usrId",required = true) String usrId){
		
		List<Family> returned = familyInfoService.fetchAllFamilyInfo(usrId);
		
		System.out.println(returned);
		
		return ResponseEntity.ok().body(returned);
	}

}

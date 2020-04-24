package com.expleopune.hr.onboarding.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.Parameter;
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

import com.expleopune.hr.onboarding.model.EmpExpInfo;
import com.expleopune.hr.onboarding.service.EmpExpService;

@RestController
@RequestMapping(value = "api/empexpinfo-service")
public class EmpExpInfoController {
	
	@Autowired 
	EmpExpService empExpService;
	
	
	@PostMapping
	public ResponseEntity<Boolean> postEmpExpInfo(@RequestBody EmpExpInfo empExpInfo){
		
		boolean posted = empExpService.addEmpExp(empExpInfo);
		
		return ResponseEntity.ok(posted);		
	}
	
	@PutMapping//("/{empExpId}/{usrId}")
	public ResponseEntity<Boolean> modifyEmpExpInfo(@RequestBody EmpExpInfo empExpInfo, 
			@RequestParam(name = "empExpId",required = true) Long empExpId, @RequestParam(name = "usrId",required = true) String usrId){
		
		boolean modified = empExpService.updateEmpExp(empExpId, usrId, empExpInfo);
		
		return ResponseEntity.ok(modified);
	}
	
	@GetMapping //("/{usrId}")
	public  ResponseEntity<List<EmpExpInfo>> returnEmpExpInfo(@RequestParam(name = "usrId",required = true) String usrId){
		
		List<EmpExpInfo> returned = empExpService.fetchAllEmpExpInfo(usrId);
		
		System.out.println(returned);
		
		return ResponseEntity.ok().body(returned);
	}
}

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

import com.expleopune.hr.onboarding.controller.service.ProfRefService;
import com.expleopune.hr.onboarding.model.ProfRef;

@RestController
@RequestMapping(value = "api/profrefinfo-service")
public class ProfRefController {
	
	@Autowired
	ProfRefService profRefService;
	
	
	@PostMapping
	public ResponseEntity<Boolean> postProfRef(@RequestBody ProfRef profRef){
		boolean posted = profRefService.addProfRef(profRef);
		return ResponseEntity.ok(posted);
	}
	
	@PutMapping
	public ResponseEntity<Boolean> modifyProfRef(@RequestParam(name = "profRefId") long profRefId,
			@RequestParam(name = "usrId") String usrId, @RequestBody ProfRef profRef){
		boolean modified = profRefService.updateProfRef(profRefId, usrId, profRef);
		return ResponseEntity.ok(modified);
	}
	
	@GetMapping
	public ResponseEntity<List<ProfRef>> retunAllProfRef(@RequestParam(name = "usrId") String usrId){
		List<ProfRef> profRefList = profRefService.fetchAllProfRef(usrId);
		
		return ResponseEntity.ok().body(profRefList);
	}

}

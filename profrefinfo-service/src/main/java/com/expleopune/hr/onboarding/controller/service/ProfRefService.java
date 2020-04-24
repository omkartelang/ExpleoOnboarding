package com.expleopune.hr.onboarding.controller.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expleopune.hr.onboarding.controller.repository.ProfRefRepository;
import com.expleopune.hr.onboarding.model.ProfRef;

@Service
public class ProfRefService {

	@Autowired
	ProfRefRepository profRefRepository;
	
	public boolean addProfRef(ProfRef profRef) {
		
		ProfRef saved = profRefRepository.save(profRef);
		
		if(saved != null) {
			return true;
		}else {
			throw new ProfRefNotCreatedException();
		}
		
	}
	
	public boolean updateProfRef(long profRefId, String usrId, ProfRef profRef) {
		Optional<ProfRef> profRefIdOptional = profRefRepository.findById(profRefId);
		
		List<ProfRef> profRefUsrIdList = profRefRepository.findByUsrId(usrId);
		
		if(profRefIdOptional != null && profRefUsrIdList != null) {
			profRef.setProfrefId(profRefId);
			profRef.setUsrId(usrId);
			
			ProfRef updated = profRefRepository.save(profRef);
			
			if(updated != null) {
				return true;
			}else {
				throw new ProfRefNotUpdatingException();
			}
		}else {
			throw new ProfRefNotExstingException();
		}
	}
	
	public List<ProfRef> fetchAllProfRef(String usrId) {
		//Optional<ProfRef> profRefIdOptional = profRefRepository.findById(profRefId);
		
		List<ProfRef> profRefUsrIdList = profRefRepository.findByUsrId(usrId);
		
		if(profRefUsrIdList != null) {
			return profRefUsrIdList;
		}else {
			throw new ProfRefNotExstingException();
		}
	}
	
	public static class ProfRefNotCreatedException extends RuntimeException{
		
	}
	
	public static class ProfRefNotExstingException extends RuntimeException{
		
	}
	
	public static class ProfRefNotUpdatingException extends RuntimeException{
		
	}

	
}

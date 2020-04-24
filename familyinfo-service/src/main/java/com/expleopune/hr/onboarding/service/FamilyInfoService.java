package com.expleopune.hr.onboarding.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expleopune.hr.onboarding.model.Family;
import com.expleopune.hr.onboarding.repository.FamilyRepository;

@Service
public class FamilyInfoService {

	@Autowired
	FamilyRepository familyRespository;
	
	//persists employee experience information to database.......
	public boolean addFamily(Family family)
	{
		Family added = familyRespository.save(family);
		
		if(added !=null)
		{
			return true;
		}else{
            throw new FamilyInfoNotCreatedException();
        }
	}
	
	
	//updates exisitng employee experience information to database.......
	public boolean updateFamily(long familyId,String usrId ,Family family) {
		
		Optional<Family> familyOptionalById= familyRespository.findById(familyId);
		
		List<Family> familyOptionalByUsrId =  familyRespository.findByUsrId(usrId);
		
		if(familyOptionalById != null && familyOptionalByUsrId !=null)
		{
			family.setFamilyId(familyId);
			
			family.setUsrId(usrId);
						
			Family updated = familyRespository.save(family);
			
			if(updated != null)
			{
				return true;
			}else {
				throw new FamilyInfoNotCreatedException();
			}
			
		}else {
			throw new FamilyInfoExistException();
		}
	}
	
	//Get all employee experience information from database.......
	public List<Family> fetchAllFamilyInfo(String usrId)
	{
		List<Family> empExpOptionalByUsrId =  familyRespository.findByUsrId(usrId);
		
		System.out.println(empExpOptionalByUsrId);
		
		if(empExpOptionalByUsrId != null)
		{
			return empExpOptionalByUsrId;
		}else{
			throw new FamilyInfoExistException();
		}
		
	}
	
	public static class FamilyInfoNotCreatedException extends RuntimeException{
		
	}
	
	public static class FamilyInfoExistException extends RuntimeException{
		
	}
}

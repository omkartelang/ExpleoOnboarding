package com.expleopune.hr.onboarding.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expleopune.hr.onboarding.model.EmpExpInfo;
import com.expleopune.hr.onboarding.repository.EmpExpRepository;

@Service
public class EmpExpService {

	@Autowired
	EmpExpRepository empExpRepository;
	
	//persists employee experience information to database.......
	public boolean addEmpExp(EmpExpInfo empExpInfo)
	{
		EmpExpInfo added = empExpRepository.save(empExpInfo);
		
		if(added !=null)
		{
			return true;
		}else{
            throw new EmpExpNotCreatedException();
        }
	}
	
	
	//updates exisitng employee experience information to database.......
	public boolean updateEmpExp(long empExpId,String usrId ,EmpExpInfo empExpInfo) {
		
		Optional<EmpExpInfo> empExpOptionalById= empExpRepository.findById(empExpId);
		
		List<EmpExpInfo> empExpOptionalByUsrId =  empExpRepository.findByUsrId(usrId);
		
		if(empExpOptionalById != null && empExpOptionalByUsrId !=null)
		{
			empExpInfo.setEmpExpId(empExpId);
			
			empExpInfo.setUsrId(usrId);
						
			EmpExpInfo updated = empExpRepository.save(empExpInfo);
			
			if(updated != null)
			{
				return true;
			}else {
				throw new EmpExpNotCreatedException();
			}
			
		}else {
			throw new EmpExpNotExistException();
		}
	}
	
	//Get all employee experience information from database.......
	public List<EmpExpInfo> fetchAllEmpExpInfo(String usrId)
	{
		List<EmpExpInfo> empExpOptionalByUsrId =  empExpRepository.findByUsrId(usrId);
		
		System.out.println(empExpOptionalByUsrId);
		
		if(empExpOptionalByUsrId != null)
		{
			return empExpOptionalByUsrId;
		}else{
			throw new EmpExpNotExistException();
		}
		
	}
	
	public static class EmpExpNotCreatedException extends RuntimeException{
		
	}
	
	public static class EmpExpNotExistException extends RuntimeException{
		
	}
}



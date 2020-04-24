package com.expleopune.hr.onboarding.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expleopune.hr.onboarding.model.Educations;
import com.expleopune.hr.onboarding.repository.EducationInfoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EducationsService {
	
	@Autowired
	EducationInfoRepository educationInfoRepository;
	
	public boolean addEduDetails(Educations educaitons)
	{
		Educations saved = educationInfoRepository.save(educaitons);
		
		if(saved !=null)
		{
			return true;
		}else{
            throw new EducationNotCreatedException();
        }
	}
	
	public boolean updateEduInfo(long eduId,Educations educations) {
			
		Educations updated = educationInfoRepository.save(educations);
			
			if(updated != null)
			{
				return true;
			}else{
	            throw new EducationNotCreatedException();
	        }
		}
	
	public String getEduInfo(long id) throws JsonProcessingException
	{
		Educations eduOjb = educationInfoRepository.findById(id).get();
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		String valueAsString = objectMapper.writeValueAsString(eduOjb);
		
		//System.out.println("Get result object");
		
		//System.out.println(personaOjb);
		
		//System.out.println("Get json string");
		
		//System.out.println(valueAsString);
		
		return valueAsString;
	}
	
	
	
	public static class EducationNotCreatedException extends RuntimeException{
		
	}



	
}

package com.expleopune.hr.onboarding.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expleopune.hr.onboarding.model.Person;
import com.expleopune.hr.onboarding.repository.PersonalInfoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PersonalInfoService {
	
	@Autowired 
	PersonalInfoRepository personalInfoRepository;
	
	public boolean addPersonalInfo(Person person) {
		
		Person added = personalInfoRepository.save(person);
		
		if(added != null)
		{
			return true;
		}else{
            throw new PersonNotCreatedException();
        }
	}
	
	public boolean updatePersonalInfo(long id,Person person) {
			
			Person updated = personalInfoRepository.save(person);
			
			if(updated != null)
			{
				return true;
			}else{
	            throw new PersonNotCreatedException();
	        }
		}
	
	public String getPersonalInfo(long id) throws JsonProcessingException
	{
		Person personaOjb = personalInfoRepository.findById(id).get();
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		String valueAsString = objectMapper.writeValueAsString(personaOjb);
		
		//System.out.println("Get result object");
		
		//System.out.println(personaOjb);
		
		//System.out.println("Get json string");
		
		//System.out.println(valueAsString);
		
		return valueAsString;
	}
	
	public boolean updtePersonInfo(Person person)
	{
		personalInfoRepository.save(person);
		return true;
	}
	
	public static class PersonNotCreatedException extends RuntimeException{
		
	}
}

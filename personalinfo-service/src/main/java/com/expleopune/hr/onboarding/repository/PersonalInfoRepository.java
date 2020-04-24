package com.expleopune.hr.onboarding.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expleopune.hr.onboarding.model.Person;

@Repository
public interface PersonalInfoRepository extends JpaRepository<Person, Long> {
	
	//Optional<Person>findBy(long id);
}

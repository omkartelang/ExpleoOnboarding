package com.expleopune.hr.onboarding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.expleopune.hr.onboarding.model.Educations;

@Repository
public interface EducationInfoRepository extends JpaRepository<Educations,Long> {
	

}

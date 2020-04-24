package com.expleopune.hr.onboarding.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.expleopune.hr.onboarding.model.Family;

@Repository
public interface FamilyRepository extends JpaRepository<Family, Long> {

	@Query("FROM Family e WHERE e.usrId = ?1")
	List<Family> findByUsrId(String usrId);
}

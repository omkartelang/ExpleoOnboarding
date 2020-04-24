package com.expleopune.hr.onboarding.controller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.expleopune.hr.onboarding.model.ProfRef;

@Repository
public interface ProfRefRepository extends JpaRepository<ProfRef, Long> {

	@Query("FROM ProfRef e WHERE e.usrId = ?1")
	List<ProfRef> findByUsrId(String usrId);

}

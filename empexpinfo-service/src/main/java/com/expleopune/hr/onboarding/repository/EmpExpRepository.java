package com.expleopune.hr.onboarding.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.expleopune.hr.onboarding.model.EmpExpInfo;

@Repository
public interface EmpExpRepository extends JpaRepository<EmpExpInfo, Long> {

	@Query("FROM EmpExpInfo e WHERE e.usrId = ?1 ORDER BY e.toDate DESC")
	List<EmpExpInfo> findByUsrId(String usrId);
	
}

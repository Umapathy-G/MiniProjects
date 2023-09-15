package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entities.UserReport;

public interface UserReportRepo extends JpaRepository<UserReport, Integer> {

	@Query("select distinct(planName) from UserReport")
	public List<String> getUniquePlanName();
	
	@Query("select distinct(planStatus) from UserReport")
	public List<String> getUniquePlanStatus();
	
}

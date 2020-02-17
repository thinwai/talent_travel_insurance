package com.travelinsurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travelinsurance.dto.Plan;

public interface PlanRepository extends JpaRepository<Plan, Integer>{

}

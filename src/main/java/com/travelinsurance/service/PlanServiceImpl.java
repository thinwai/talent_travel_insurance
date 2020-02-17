package com.travelinsurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelinsurance.dto.Plan;
import com.travelinsurance.repository.PlanRepository;

@Service
public class PlanServiceImpl implements PlanService{
	
	@Autowired
	PlanRepository planRepo;

	@Override
	public List<Plan> findAllPlan() {
		// TODO Auto-generated method stub
		return planRepo.findAll();
	}

}

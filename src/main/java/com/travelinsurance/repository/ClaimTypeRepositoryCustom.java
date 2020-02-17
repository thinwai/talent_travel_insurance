package com.travelinsurance.repository;

import java.util.List;

import com.travelinsurance.dto.ClaimType;
import com.travelinsurance.dto.Proposal;

public interface ClaimTypeRepositoryCustom {
	
	List<ClaimType> findByPlanId(int planId);
	Proposal findToClaim(String propoId);

}

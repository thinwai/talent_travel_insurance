package com.travelinsurance.repository;

import com.travelinsurance.dto.User;

public interface BeneficialRepositoryCustom {
	
	String findLargestProposalId(User user);

}

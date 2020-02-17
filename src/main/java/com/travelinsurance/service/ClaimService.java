package com.travelinsurance.service;

import java.util.List;

import com.travelinsurance.view_model.ClaimModel;
import com.travelinsurance.view_model.ClaimTypeModel;
import com.travelinsurance.view_model.UserProposalModel;

public interface ClaimService {
	
	List<ClaimTypeModel> searchClaimType(int planId);
	
	Integer findToClaim(ClaimModel cModel);
	
	void saveClaim(ClaimModel cModel);
}

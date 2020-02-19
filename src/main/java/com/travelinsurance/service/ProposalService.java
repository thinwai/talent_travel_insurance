package com.travelinsurance.service;

import com.travelinsurance.dto.User;
import com.travelinsurance.view_model.UserProposalModel;

public interface ProposalService {
	
	void saveProposal(UserProposalModel propoModel);
	
	UserProposalModel searchPropoId(String propoId, User user);

}

package com.travelinsurance.repository;

import java.util.List;

import com.travelinsurance.dto.Proposal;
import com.travelinsurance.dto.User;

public interface ProposalRepositoryCustom {
	
	Proposal searchProposalId(String propoId, User user);
	Proposal searchProId(String propoId);

	List<Proposal> proposalRequest();											// for Admin
}

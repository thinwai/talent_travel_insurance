package com.travelinsurance.repository;

import java.util.List;

import com.travelinsurance.dto.Proposal;
import com.travelinsurance.dto.Tests;

public interface ProposalRepositoryCustom {
	
	//List<Proposal> searchList();
	//List<Tests> searchLists();
	Proposal searchProposalId(String propoId);

}

package com.travelinsurance.service;

import java.util.List;

import com.travelinsurance.dto.User;
import com.travelinsurance.view_model.ListModel;
import com.travelinsurance.view_model.SearchModel;
import com.travelinsurance.view_model.UserProposalModel;

public interface ListService {
	
	List<ListModel> detailList(User user,SearchModel search);

	Boolean deleteProposal(String id);
	
	UserProposalModel getAllData(String propoId);

}

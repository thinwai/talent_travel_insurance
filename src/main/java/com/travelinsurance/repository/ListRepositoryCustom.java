package com.travelinsurance.repository;

import java.util.List;

import com.travelinsurance.dto.Proposal;
import com.travelinsurance.dto.User;

public interface ListRepositoryCustom {
	
	List<Proposal> viewList(User user);

}

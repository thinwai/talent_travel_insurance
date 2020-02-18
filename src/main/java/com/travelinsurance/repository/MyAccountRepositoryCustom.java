package com.travelinsurance.repository;

import com.travelinsurance.dto.User;

public interface MyAccountRepositoryCustom {

	//Long totalPolicy(User user);
	Integer findTotalpolicy(User user);
	Integer findTotalClaim(User user);

}

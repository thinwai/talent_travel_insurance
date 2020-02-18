package com.travelinsurance.repository;

import com.travelinsurance.dto.User;

public interface MyAccountRepositoryCustom {

	Integer findTotalpolicy(User user);
	Integer findTotalClaim(User user);

}

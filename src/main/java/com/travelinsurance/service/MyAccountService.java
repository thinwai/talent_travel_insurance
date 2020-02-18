package com.travelinsurance.service;

import com.travelinsurance.dto.User;

public interface MyAccountService {

	Integer totalPolicy(User user);
	Integer totalClaimt(User user);
}

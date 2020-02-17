package com.travelinsurance.repository;

import com.travelinsurance.dto.User;

public interface UserRepositoryCustom {
	
	User findByEmail(User user);

}

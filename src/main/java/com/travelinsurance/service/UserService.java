package com.travelinsurance.service;

import org.springframework.stereotype.Service;

import com.travelinsurance.dto.User;
import com.travelinsurance.view_model.UserModel;

@Service
public interface UserService {

	void userSave(UserModel user);													
	boolean findByEmail(UserModel user);
	Integer userLogin(UserModel user);
	User session(User user);
	
	
}

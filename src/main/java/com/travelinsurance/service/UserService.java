package com.travelinsurance.service;

import org.springframework.stereotype.Service;
import com.travelinsurance.view_model.UserModel;

@Service
public interface UserService {

	void userSave(UserModel user);													//Chit Su
	boolean findByEmail(UserModel user);
	
}

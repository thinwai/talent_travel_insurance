package com.travelinsurance.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelinsurance.dto.User;
import com.travelinsurance.repository.UserRepository;
import com.travelinsurance.view_model.UserModel;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository uRepo;
	
	@Override
	public void userSave(UserModel user) {															//Chit Su

		User userdto = new User();
		userdto.setEmail(user.getEmail());
		userdto.setUsername(user.getUsername());
		userdto.setPassword(user.getPassword());
		userdto.setUserAccStatus(1);
		uRepo.save(userdto);
		
	}

	@Override
	public boolean findByEmail(UserModel user) {
		
		User usr=new User();
		usr.setEmail(user.getEmail());
		
		try {
			User result=uRepo.findByEmail(usr);
			if(result.equals("") || result.equals(null)) {
				return true;
			}else {
				return false;
			}
		}catch (NullPointerException e) {
			return true;
		}catch (Exception e) {
			return true;
		}
	}
	
}

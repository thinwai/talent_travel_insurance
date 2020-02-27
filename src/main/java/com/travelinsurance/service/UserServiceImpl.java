package com.travelinsurance.service;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
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
	public void userSave(UserModel user) {

		User userdto = new User();
		userdto.setuId(user.getuId());
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

	@Override
	public Integer userLogin(UserModel user) {
		
		int loginResult=0;
		
		User usr=new User();
		usr.setEmail(user.getEmail());
		
		try {
			User result=uRepo.findByEmail(usr);
			
			
			if(result.getPassword().equals(user.getPassword())){
				
				if(result.getUserAccStatus() == 1) {
					
					FacesContext facesContext=FacesContext.getCurrentInstance();
					HttpSession session=(HttpSession) facesContext.getExternalContext().getSession(true);
					session.setAttribute("session", result);
					session.setAttribute("email", result.getEmail());
					
				}else {
					loginResult=3;
				}
				
			}else {
				loginResult=2;
			}
			
		}catch (Exception e) {
			System.out.println("3");
			loginResult=1;
		}
		
		return loginResult;
	}

	@Override
	public User session(User user) {
		return  uRepo.findByEmail(user);
	}
	
}

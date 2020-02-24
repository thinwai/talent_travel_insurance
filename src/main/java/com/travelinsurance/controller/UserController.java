package com.travelinsurance.controller;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.travelinsurance.dto.User;
import com.travelinsurance.service.MyAccountService;
import com.travelinsurance.service.UserService;
import com.travelinsurance.util.MessagesUtil;
import com.travelinsurance.view_model.UserModel;         //com.travelinsurance.view_model.UserModel


@Named
@ViewScoped
public class UserController {
	private UserModel user=new UserModel();
	
	@Autowired
	private UserService uService;
	
	@Autowired
	private MyAccountService accService;
	
	@Autowired
	MessagesUtil msg;				
	
	public String home() {
		return "homePage.xhtml?faces-redirect=true";
	}
	
	public String myAcc() {
		System.out.println("login 1");
		FacesContext facesContext=FacesContext.getCurrentInstance();
		HttpSession session=(HttpSession) facesContext.getExternalContext().getSession(true);
		
		try {
			User user=new User();
			user=(User) session.getAttribute("session");
			user=uService.session(user);
			
			this.user.setuId(user.getuId());
			this.user.setEmail(user.getEmail());
			this.user.setUsername(user.getUsername());
			this.user.setPassword(user.getPassword());
			this.user.setConPassword(user.getPassword());
			this.user.setTotalPolicy(accService.totalPolicy(uService.session(user)));
			this.user.setTotalClaim(accService.totalClaimt(uService.session(user)));
		}catch (Exception e) {
		}
		return "myaccPage.xhtml?faces-redirect=true";
	}
	
	public String userSave() {																						// Chit Su
		
		System.out.println("1");
		if(this.user.getuId()!=0) {
			uService.userSave(user);
			user=new UserModel();
			myAcc();
			msg.messageInfo("Update Successfully");
			return "myaccPage.xhtml?faces-redirect=true";
		}else {
			System.out.println("controller 1 "+user.getEmail());
			boolean status=uService.findByEmail(user);
			if(status) {
				uService.userSave(user);
				user=new UserModel();
				msg.messageInfo("Register Successfully");
			}else {
				msg.messageInfo("Email is already in used!");
			}
		}
		return null;
	}
	
	public String userLogin() {
		
		int result=uService.userLogin(user);
		System.out.println("<<<<<<<<<<<<<<<<< _____ " +result);
		if(result==1) {
			msg.messageInfo("User Does not Exist!");
		}else if(result==2) {
			msg.messageInfo("Password is not Correct!");
		}else if(result==3) {
			msg.messageInfo("Your Account is Already Delete!");
		}else {
			
			msg.messageInfo("Success!");
			return "homePage.xhtml?faces-redirect=true";
		}
		//return "homePage.xhtml?faces-redirect=true";
		return null;
	}
	
	public String userEdit() {
		
		return "userRegistrationPage.xhtml?faces-redirect=true";
	}
	
	
	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}
	
	

}

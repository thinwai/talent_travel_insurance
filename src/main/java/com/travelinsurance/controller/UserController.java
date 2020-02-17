package com.travelinsurance.controller;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

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
		return "myaccPage.xhtml?faces-redirect=true";
	}
	
	public void userSave() {																						// Chit Su
		
		System.out.println("controller 1 "+user.getEmail());
		boolean status=uService.findByEmail(user);
		if(status) {
			uService.userSave(user);
			msg.messageInfo("Register Successfully");
		}else {
			msg.messageInfo("Email is already in used!");
		}
	}
	
	@PostConstruct
	public void totalPolicy() {
		User user = new User();
		user.setuId(1);
		accService.totalPolicy(user);
	}
	
	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}
	
	

}

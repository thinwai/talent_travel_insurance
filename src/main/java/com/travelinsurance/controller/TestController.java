package com.travelinsurance.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.travelinsurance.service.TestService;
import com.travelinsurance.util.MessagesUtil;

@Controller
public class TestController {
	
	@Autowired
	TestService testService;
	
	@Autowired
	MessagesUtil message;
	
	@PostConstruct
	public void init() {
		
		String s=message.proposalId();
		
		System.out.println("CONTROLLER ID | "+s);
		
	}
	
	public void test() {
		message.messageError("error");
	}

}

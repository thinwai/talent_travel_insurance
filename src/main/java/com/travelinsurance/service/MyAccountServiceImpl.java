package com.travelinsurance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelinsurance.dto.User;
import com.travelinsurance.repository.MyAccountRepository;

@Service
public class MyAccountServiceImpl implements MyAccountService {

	@Autowired
	MyAccountRepository accRepo;
	
	@Override
	public Long totalPolicy(User user) {
		Long totalPolicy =accRepo.totalPolicy(user);
		System.out.println("mmcs   " + totalPolicy);
		return null;
	}

	
}

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
	public Integer totalPolicy(User user) {
		// TODO Auto-generated method stub
		return accRepo.findTotalpolicy(user);
	}
	@Override
	public Integer totalClaimt(User user) {
		// TODO Auto-generated method stub
		return accRepo.findTotalClaim(user);
	}
}

package com.travelinsurance.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelinsurance.dto.Proposal;
import com.travelinsurance.dto.Test;
import com.travelinsurance.dto.Tests;
import com.travelinsurance.repository.ProposalRepository;

@Service
@Transactional
public class TestServiceImpl implements TestService{

	
	@Autowired
	ProposalRepository pRepo;
	/*
	@Override
	public List<Tests> tests() {
		List<Tests> list=pRepo.searchLists();
		for (Tests temp : list) {
			Tests tests=new Tests();
			Test test=new Test();
			
			System.out.println(temp.getTwoId());
			System.out.println(temp.getName());
			System.out.println(temp.getTest().getId());
			System.out.println(temp.getTest().getName());
		}
		return null;
	}

	@Override
	public List<Proposal> proTests() {
		List<Proposal> list=pRepo.searchList();
		for (Proposal temp : list) {
			Tests tests=new Tests();
			Test test=new Test();
			
			System.out.println(temp.getpId());
			System.out.println(temp.getHolderName());
			System.out.println(temp.getNrc());
			System.out.println(temp.getPlace());
			System.out.println(temp.getVehicleNo());
			System.out.println(temp.getSumInsurance());
			System.out.println(temp.getUser().getuId());
			System.out.println(temp.getUser().getEmail());
			System.out.println(temp.getUser().getUsername());
			System.out.println(temp.getUser().getPassword());
			System.out.println(temp.getUser().getUserAccStatus());
		}
		return null;
	}
	*/
}

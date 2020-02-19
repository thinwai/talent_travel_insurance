package com.travelinsurance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelinsurance.dto.Plan;
import com.travelinsurance.dto.Proposal;
import com.travelinsurance.dto.User;
import com.travelinsurance.dto.Vehicle;
import com.travelinsurance.repository.ProposalRepository;
import com.travelinsurance.view_model.ClaimModel;
import com.travelinsurance.view_model.UserProposalModel;

@Service
public class ProposalServiceImpl implements ProposalService{
	
	@Autowired
	ProposalRepository propoRepo;
	
	@Override
	public void saveProposal(UserProposalModel propoModel) {
		
		Proposal propo=new Proposal();
		propo.setpId(propoModel.getpId());
		propo.setHolderName(propoModel.getHolderName());
		propo.setDob(propoModel.getDob());
		propo.setNrc(propoModel.getHolderNrc());
		propo.setHolderPhone(propoModel.getHolderPhone());
		propo.setFromPlace(propoModel.getFromPlace());
		propo.setToPlace(propoModel.getToPlace());
		propo.setStartDate(propoModel.getStartDate());
		propo.setEndDate(propoModel.getEndDate());
		propo.setVehicleNo(propoModel.getVehicleNo());
		propo.setSumInsurance(propoModel.getSumInsurance());
		
		propo.setProposalStatus(1);
		
		propo.setUser(propoModel.getUser());
		Vehicle v=new Vehicle();
		v.setVehicleId(propoModel.getVehicle());
		
		propo.setVehicle(v);
		
		Plan p=new Plan();
		p.setPlanId(propoModel.getPlan());
		
		propo.setPlan(p);
		
		propoRepo.save(propo);
		
	}

	@Override
	public UserProposalModel searchPropoId(String propoId) {
		Proposal result=propoRepo.searchProposalId(propoId);
		
		UserProposalModel proposal=new UserProposalModel();
		
		proposal.setpId(result.getpId());
		proposal.setProposalStatus(result.getProposalStatus());
		proposal.setPlan(result.getPlan().getPlanId());
		
		return proposal;
	}
}

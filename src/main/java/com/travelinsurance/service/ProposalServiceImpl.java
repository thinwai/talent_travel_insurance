package com.travelinsurance.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelinsurance.dto.Beneficial;
import com.travelinsurance.dto.Plan;
import com.travelinsurance.dto.Proposal;
import com.travelinsurance.dto.User;
import com.travelinsurance.dto.Vehicle;
import com.travelinsurance.repository.BeneficialRepository;
import com.travelinsurance.repository.ProposalRepository;
import com.travelinsurance.view_model.UserProposalModel;

@Service
public class ProposalServiceImpl implements ProposalService{
	
	@Autowired
	ProposalRepository propoRepo;
	
	@Autowired
	BeneficialRepository bRepo;
	
	@Override
	@Transactional
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
		propo.setDuration(propoModel.getDateRange());
		propo.setVehicleNo(propoModel.getVehicleNo());
		propo.setUnit(propoModel.getUnit());
		propo.setSumInsurance(propoModel.getSumInsurance());
		
		propo.setProposalStatus(1);
		propo.setStatus(1);
		
		propo.setUser(propoModel.getUser());
		Vehicle v=new Vehicle();
		v.setVehicleId(propoModel.getVehicle());
		
		propo.setVehicle(v);
		
		Plan p=new Plan();
		p.setPlanId(propoModel.getPlan());
		
		propo.setPlan(p);
		
		propoRepo.save(propo);
		
		System.out.println("beni");
		try {
			if(!propoModel.getBeneficialName().equals(null)) {
				Beneficial beneficialdto = new Beneficial();
				beneficialdto.setbId(propoModel.getbId());
				beneficialdto.setBeneficialName(propoModel.getBeneficialName());
				beneficialdto.setNrc(propoModel.getBenificalNrc());
				beneficialdto.setRelationship(propoModel.getRelationship());
				beneficialdto.setBeneficialPh(propoModel.getBeneficialPh());
				beneficialdto.setAddress(propoModel.getAddress());
				beneficialdto.setProposalBenefit(propo);
				
				bRepo.save(beneficialdto);
				
				System.out.println("exist beni");
			}
		}catch (Exception e) {
			System.out.println("null beni");
		}
		
	}

	@Override
	public UserProposalModel searchPropoId(String propoId, User user) {
		Proposal result=propoRepo.searchProposalId(propoId,user);
		
		UserProposalModel proposal=new UserProposalModel();
		
		proposal.setpId(result.getpId());
		proposal.setProposalStatus(result.getProposalStatus());
		proposal.setPlan(result.getPlan().getPlanId());
		proposal.setSumInsurance(result.getSumInsurance());
		
		return proposal;
	}
}

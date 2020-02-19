package com.travelinsurance.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelinsurance.dto.Beneficial;
import com.travelinsurance.dto.Proposal;
import com.travelinsurance.repository.BeneficialRepository;
import com.travelinsurance.view_model.UserProposalModel;

@Service
@Transactional
public class BeneficialServiceImpl implements BeneficialService {

	@Autowired
	BeneficialRepository bRepo;

	@Override
	public void beneficialSave(UserProposalModel uProposalModel) {
		
		String propoId=bRepo.findLargestProposalId(uProposalModel.getUser());
		
		Beneficial beneficialdto = new Beneficial();
		beneficialdto.setBeneficialName(uProposalModel.getBeneficialName());
		beneficialdto.setNrc(uProposalModel.getBenificalNrc());
		beneficialdto.setRelationship(uProposalModel.getRelationship());
		beneficialdto.setBeneficialPh(uProposalModel.getBeneficialPh());
		beneficialdto.setAddress(uProposalModel.getAddress());
		
		Proposal propo=new Proposal();
		propo.setpId(propoId);
		beneficialdto.setProposalBenefit(propo);
		
		bRepo.save(beneficialdto);
		
	}
	
	
}

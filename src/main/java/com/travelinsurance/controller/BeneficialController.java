package com.travelinsurance.controller;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.travelinsurance.service.BeneficialService;
import com.travelinsurance.view_model.UserProposalModel;

@Named
@ViewScoped
public class BeneficialController {

	private UserProposalModel uProposalModel = new UserProposalModel();
	
	@Autowired
	private BeneficialService bService;
	
	public void beneficialSave() {
		
		System.out.println("222");
		System.out.println(uProposalModel.getBeneficialName());
		System.out.println(uProposalModel.getBeneficialPh());
		bService.beneficialSave(uProposalModel);
	}

	public UserProposalModel getuProposalModel() {
		return uProposalModel;
	}

	public void setuProposalModel(UserProposalModel uProposalModel) {
		this.uProposalModel = uProposalModel;
	}
	
	
	}

package com.travelinsurance.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelinsurance.dto.Claim;
import com.travelinsurance.dto.ClaimType;
import com.travelinsurance.dto.Payment;
import com.travelinsurance.dto.Proposal;
import com.travelinsurance.repository.ClaimRepository;
import com.travelinsurance.repository.ClaimTypeRepository;
import com.travelinsurance.repository.PaymentRepository;
import com.travelinsurance.repository.ProposalRepository;
import com.travelinsurance.util.MessagesUtil;
import com.travelinsurance.view_model.ClaimModel;
import com.travelinsurance.view_model.ClaimTypeModel;
import com.travelinsurance.view_model.PaymentModel;

@Service
public class ClaimServiceImpl implements ClaimService{

	@Autowired
	MessagesUtil msg;
	
	@Autowired
	ClaimTypeRepository ctRepo;
	
	@Autowired
	ClaimRepository claim;
	
	@Autowired
	PaymentRepository payRepo;
	
	@Autowired
	ProposalRepository propo;
	
	@Override
	public List<ClaimTypeModel> searchClaimType(int planId) {
		System.out.println("____Service____1");
		List<ClaimType> result=ctRepo.findByPlanId(planId);
		System.out.println("____Service____2");
		
		List<ClaimTypeModel> list=new ArrayList<ClaimTypeModel>(); 
		for (ClaimType temp : result) {
			
			ClaimTypeModel ctModel=new ClaimTypeModel();
			ctModel.setCtId(temp.getCtId());
			ctModel.setClaimType(temp.getClaimType());
			ctModel.setAmount(temp.getAmount());
			
			list.add(ctModel);
		}
		return list;
	}

	@Override
	public Integer findToClaim(ClaimModel cModel) {
		System.out.println("s2");
		Proposal propo=ctRepo.findToClaim(cModel.getPropoId());
		System.out.println("s3");
		String name=cModel.getClaimName().toLowerCase();System.out.println("s4");
		String holderName=propo.getHolderName().toLowerCase();System.out.println("s5");
		
		int lostDate=msg.dateToInteger(cModel.getLostDate());
		int endDate=msg.dateToInteger(propo.getEndDate());
		int startDate=msg.dateToInteger(propo.getStartDate());
		
		int result = 0;
		try {
		String beneficialName=propo.getBeneficial().get(0).getBeneficialName().toLowerCase();System.out.println("s6");
		
		
		if (holderName.equals(name) || beneficialName.equals(name)) {
			if(holderName.equals(name)) {
				if(propo.getNrc().equals(cModel.getClaimNrc())) {
					if(startDate<=lostDate && lostDate<=endDate) {
						result=0;
					}else {
						result=4;												//Lost_Date Must Be Your Duration of Your Travelling
					}
				}else {
					result=2;													// Your Nrc No is not Right!
				}
			}else if(beneficialName.equals(name)) {
				if(propo.getBeneficial().get(0).getNrc().equals(cModel.getClaimNrc())) {
					if(startDate<lostDate && lostDate<endDate) {
						result=0;
					}else {
						result=4;												//Lost_Date Must Be Your Duration of Your Travelling
					}
				}else {
					result=3;													// Beneficial Nrc No is not Right!
				}
			}
		}else {
			result=1;															//Name must be policy holder Name or Beneficial Name
		}
		}catch (Exception e) {
			System.out.println("s7");
			if(holderName.equals(name)) {
				if(propo.getNrc().equals(cModel.getClaimNrc())) {
					if(startDate<=lostDate && lostDate<=endDate) {
						result=0;
					}else {
						result=4;												//Lost_Date Must Be Your Duration of Your Travelling
					}
				}else {
					result=2;													// Your Nrc No is not Right!
				}
			}else {
				result=1;
			}
		}
		
		return result;
	}


	@Override
	public Integer findClaimByPropoId(String propoId) {
		// TODO Auto-generated method stub
		return claim.findClaimByProposalId(propoId);
	}

	@Override
	public ClaimModel saveClaim(ClaimModel cModel) {
		Payment result=payRepo.searchPayment(cModel.getPropoId(), true);
		Proposal proposal=propo.searchProId(cModel.getPropoId());
		
		Claim cl=new Claim();
		cl.setClaimName(cModel.getClaimName());
		cl.setClaimNrc(cModel.getClaimNrc());
		cl.setClaimPhone(cModel.getClaimPhone());
		cl.setLostDate(cModel.getLostDate());
		cl.setClaimAmount(cModel.getClaimAmount());
		cl.setReason(cModel.getReason());
		cl.setClaimStatus(1);
		
		Payment payModel=new Payment();
		payModel.setPayId(result.getPayId());
		
		cl.setPaymentClaim(payModel);
		
		ClaimType ct=new ClaimType();
		ct.setCtId(cModel.getClaimType());
		cl.setClaimType(ct);
		
		cl.setClaimAmount((double)(proposal.getUnit() * cModel.getClaimTypeAmount() * proposal.getPlan().getPlanId()));
		
		claim.save(cl);
		
		
		//for UI
		int totalAmount=(proposal.getUnit() * cModel.getClaimTypeAmount() * proposal.getPlan().getPlanId());
		cModel.setClaimAmount((double)totalAmount);
		cModel.setCliamAmountFormat(String.valueOf(totalAmount));
		System.out.println("Total Amount | "+cModel.getClaimAmount());
		return cModel;
	}


	
}

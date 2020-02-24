package com.travelinsurance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelinsurance.dto.Payment;
import com.travelinsurance.dto.Proposal;
import com.travelinsurance.repository.PaymentRepository;
import com.travelinsurance.view_model.PaymentModel;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	PaymentRepository payRepo;

	@Override
	public Boolean searchPayment(String propoId, boolean statusCheck) {
		try {
			Payment result=payRepo.searchPayment(propoId, statusCheck);
			if(result.equals("") || result.equals(null)) {
				return false;
			}else {
				return true;
			}
		}catch (NullPointerException e) {
			return false;
		}catch (Exception e) {
			System.out.println("Exception ___>"+e);
			return false;
		}
	}

	@Override
	public Integer save(PaymentModel payModel) {
		Payment payment=new Payment();
		int result = 0;
		
		try {
			payment=payRepo.searchByProposalId(payModel.getProposalPayment());
			
			if(payment.getPayStatus()==1) {										//You have already waiting for this Payment
				result=1;								
			}else if(payment.getPayStatus()==2) {								//Cancle payment Repay
			
				payment.setPayId(payment.getPayId());
				payment.setBank(payModel.getBank());
				payment.setCardNo(payModel.getCardNo());
				payment.setExpiredDate(payModel.getExpiredDate());
				payment.setPayStatus(1);
				
				Proposal prop=new Proposal();
				prop.setpId(payModel.getProposalPayment());
			
				System.out.println("------------------"+payModel.getProposalPayment());
				payment.setProposalPayment(prop);
			
				payRepo.save(payment);
				result=2;														//success
			}
		}catch (Exception e) {													// new payment
			payment.setPayId(payment.getPayId());
			payment.setBank(payModel.getBank());
			payment.setCardNo(payModel.getCardNo());
			payment.setExpiredDate(payModel.getExpiredDate());
			payment.setPayStatus(1);
			
			Proposal prop=new Proposal();
			prop.setpId(payModel.getProposalPayment());
		
			System.out.println("------------------"+payModel.getProposalPayment());
			payment.setProposalPayment(prop);
		
			payRepo.save(payment);
			result=3;															//success
		}
		return result;
	}
}

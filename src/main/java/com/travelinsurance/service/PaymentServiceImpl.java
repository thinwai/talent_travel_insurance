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
	public void save(PaymentModel payModel) {
		
		//	--> check with proposal Exist or Not? 	---> when Admin Accepected payment Don`t need to pay more
		
		Payment payment=new Payment();
		payment.setBank(payModel.getBank());
		payment.setAmount(payModel.getAmount());
		payment.setPayId(1);
		
		payRepo.save(payment);
		
	}


}

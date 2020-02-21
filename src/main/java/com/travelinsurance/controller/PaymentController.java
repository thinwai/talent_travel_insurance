package com.travelinsurance.controller;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.travelinsurance.service.PaymentService;
import com.travelinsurance.view_model.PaymentModel;

@Named
@ViewScoped
public class PaymentController {
	
	@Autowired
	PaymentService payService;
	
	private PaymentModel payment=new PaymentModel();
	
	public String payment() {
		return "paymentPage.xhtml?faces-redirect=true";
	}
	
	public void paySave() {
		System.out.println("+++++++++++++++++++++ "+payment.getProposalPayment());
		payService.save(payment);
	}

	public PaymentModel getPayment() {
		return payment;
	}

	public void setPayment(PaymentModel payment) {
		this.payment = payment;
	}
}

package com.travelinsurance.controller;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.travelinsurance.view_model.PaymentModel;

@Named
@ViewScoped
public class PaymentController {
	
	private PaymentModel payment=new PaymentModel();
	
	public String payment() {
		return "paymentPage.xhtml?faces-redirect=true";
	}
	
	public void paySave() {
		System.out.println(payment.getProposalPayment());
		System.out.println("File |"+payment.getFile());
	}

	public PaymentModel getPayment() {
		return payment;
	}

	public void setPayment(PaymentModel payment) {
		this.payment = payment;
	}
}

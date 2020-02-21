package com.travelinsurance.view_model;

import org.primefaces.model.UploadedFile;

import lombok.Data;

@Data
public class PaymentModel {
	
	private int payId;
	private String bank;
	private Double amount;
	private int payStatus;
	private String proposalPayment;
	
	public int getPayId() {
		return payId;
	}
	public void setPayId(int payId) {
		this.payId = payId;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public int getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(int payStatus) {
		this.payStatus = payStatus;
	}
	public String getProposalPayment() {
		return proposalPayment;
	}
	public void setProposalPayment(String proposalPayment) {
		this.proposalPayment = proposalPayment;
	}
}

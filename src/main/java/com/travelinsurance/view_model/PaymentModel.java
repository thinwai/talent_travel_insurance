package com.travelinsurance.view_model;

import org.primefaces.model.UploadedFile;

import lombok.Data;

@Data
public class PaymentModel {
	
	private int payId;
	private UploadedFile file;
	private int payStatus;
	private String proposalPayment;
	
	public int getPayId() {
		return payId;
	}
	public void setPayId(int payId) {
		this.payId = payId;
	}
	public UploadedFile getFile() {
		System.out.println("file model |"+file);
		return file;
	}
	public void setFile(UploadedFile file) {
		this.file = file;
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

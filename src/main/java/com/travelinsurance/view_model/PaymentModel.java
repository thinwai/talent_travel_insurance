package com.travelinsurance.view_model;

import java.util.Date;

import javax.validation.constraints.Future;

import org.primefaces.model.UploadedFile;

import lombok.Data;

@Data
public class PaymentModel {
	
	private int payId;
	private String bank;
	private String cardNo;
	@Future
	private Date expiredDate;
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
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public Date getExpiredDate() {
		return expiredDate;
	}
	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
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

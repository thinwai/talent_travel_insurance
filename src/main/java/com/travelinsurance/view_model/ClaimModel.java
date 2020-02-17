package com.travelinsurance.view_model;

import java.util.Date;

import lombok.Data;

@Data
public class ClaimModel {
	
	private int claimId;
	private String claimName;
	private String claimNrc;
	private String claimPhone;
	private Date lostDate;
	private Double claimAmount;
	private String reason;
	private int claimStatus;
	private int paymentClaim;
	private int claimType;
	private String propoId;
	private int payStatus;
	public int getClaimId() {
		return claimId;
	}
	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}
	public String getClaimName() {
		return claimName;
	}
	public void setClaimName(String claimName) {
		this.claimName = claimName;
	}
	public String getClaimNrc() {
		return claimNrc;
	}
	public void setClaimNrc(String claimNrc) {
		this.claimNrc = claimNrc;
	}
	public String getClaimPhone() {
		return claimPhone;
	}
	public void setClaimPhone(String claimPhone) {
		this.claimPhone = claimPhone;
	}
	public Date getLostDate() {
		return lostDate;
	}
	public void setLostDate(Date lostDate) {
		this.lostDate = lostDate;
	}
	public Double getClaimAmount() {
		return claimAmount;
	}
	public void setClaimAmount(Double claimAmount) {
		this.claimAmount = claimAmount;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getClaimStatus() {
		return claimStatus;
	}
	public void setClaimStatus(int claimStatus) {
		this.claimStatus = claimStatus;
	}
	public int getPaymentClaim() {
		return paymentClaim;
	}
	public void setPaymentClaim(int paymentClaim) {
		this.paymentClaim = paymentClaim;
	}
	public int getClaimType() {
		return claimType;
	}
	public void setClaimType(int claimType) {
		this.claimType = claimType;
	}
	public String getPropoId() {
		return propoId;
	}
	public void setPropoId(String propoId) {
		this.propoId = propoId;
	}
	public int getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(int payStatus) {
		this.payStatus = payStatus;
	}
}

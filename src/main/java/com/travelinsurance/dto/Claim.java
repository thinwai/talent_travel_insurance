package com.travelinsurance.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Claim {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int claimId;
	private String claimName;
	private String claimNrc;
	private String claimPhone;
	private Date lostDate;
	private Double claimAmount;
	private String reason;
	private int claimStatus;
	
	@OneToOne
	private Payment paymentClaim;
	
	@ManyToOne
	private ClaimType claimType;

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

	public Payment getPaymentClaim() {
		return paymentClaim;
	}

	public void setPaymentClaim(Payment paymentClaim) {
		this.paymentClaim = paymentClaim;
	}

	public ClaimType getClaimType() {
		return claimType;
	}

	public void setClaimType(ClaimType claimType) {
		this.claimType = claimType;
	}
	

}

package com.travelinsurance.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int payId;
	private String imageFilePath;
	private int payStatus;
	
	@OneToOne
	private Proposal proposalPayment;
	
	@OneToOne(mappedBy = "paymentClaim",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private Claim claim;

	public int getPayId() {
		return payId;
	}

	public void setPayId(int payId) {
		this.payId = payId;
	}

	public String getImageFilePath() {
		return imageFilePath;
	}

	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}

	public int getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(int payStatus) {
		this.payStatus = payStatus;
	}

	public Proposal getProposalPayment() {
		return proposalPayment;
	}

	public void setProposalPayment(Proposal proposalPayment) {
		this.proposalPayment = proposalPayment;
	}

	public Claim getClaim() {
		return claim;
	}

	public void setClaim(Claim claim) {
		this.claim = claim;
	}

}

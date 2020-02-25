package com.travelinsurance.dto;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Beneficial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bId;
	private String beneficialName;
	private String relationship;
	private String address;
	private String nrc;
	private BigDecimal beneficialPh;
	
	@ManyToOne
	private Proposal proposalBenefit;
	
	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getBeneficialName() {
		return beneficialName;
	}

	public void setBeneficialName(String beneficialName) {
		this.beneficialName = beneficialName;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNrc() {
		return nrc;
	}

	public void setNrc(String nrc) {
		this.nrc = nrc;
	}

	public BigDecimal getBeneficialPh() {
		return beneficialPh;
	}

	public void setBeneficialPh(BigDecimal beneficialPh) {
		this.beneficialPh = beneficialPh;
	}

	public Proposal getProposalBenefit() {
		return proposalBenefit;
	}

	public void setProposalBenefit(Proposal proposalBenefit) {
		this.proposalBenefit = proposalBenefit;
	}
	

}

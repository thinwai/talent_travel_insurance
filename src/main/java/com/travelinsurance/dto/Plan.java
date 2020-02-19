package com.travelinsurance.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Plan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int planId;
	private String planType;
	private int planPrice;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="pId")
	private List<Proposal> proposalPlan;
	
	@ManyToMany(mappedBy = "claimTypePlan", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<ClaimType> ctPlan;

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}
	
	public int getPlanPrice() {
		return planPrice;
	}

	public void setPlanPrice(int planPrice) {
		this.planPrice = planPrice;
	}

	public List<Proposal> getProposalPlan() {
		return proposalPlan;
	}

	public void setProposalPlan(List<Proposal> proposalPlan) {
		this.proposalPlan = proposalPlan;
	}

	public List<ClaimType> getCtPlan() {
		return ctPlan;
	}

	public void setCtPlan(List<ClaimType> ctPlan) {
		this.ctPlan = ctPlan;
	}
	
}

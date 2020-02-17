package com.travelinsurance.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class ClaimType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ctId;
	private String claimType;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="claimId")
	private List<Claim> claims;
	
	@ManyToMany
	@JoinTable(name="planId", 
				joinColumns = @JoinColumn(name="claimType_ctId"), 
				inverseJoinColumns = @JoinColumn(name="plan_planId"))
	private List<Plan> claimTypePlan;

	public int getCtId() {
		return ctId;
	}

	public void setCtId(int ctId) {
		this.ctId = ctId;
	}

	public String getClaimType() {
		return claimType;
	}

	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}

	public List<Claim> getClaims() {
		return claims;
	}

	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}

	public List<Plan> getClaimTypePlan() {
		return claimTypePlan;
	}

	public void setClaimTypePlan(List<Plan> claimTypePlan) {
		this.claimTypePlan = claimTypePlan;
	}
	
	
}

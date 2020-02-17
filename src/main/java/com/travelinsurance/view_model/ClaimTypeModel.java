package com.travelinsurance.view_model;

import lombok.Data;
@Data
public class ClaimTypeModel {
	
	private int ctId;
	private String claimType;
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
	
	
}

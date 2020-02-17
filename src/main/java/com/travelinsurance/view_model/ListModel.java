package com.travelinsurance.view_model;

import java.util.Date;

import lombok.Data;

@Data
public class ListModel {
	private String propoId;
	private String holderName;
	private String travelFromPlace;
	private String travelToPlace;
	private Date startDate;
	private Date endDate;
	private String beneficialName;
	private int propoStatus;
	private int payStatus;
	private int claimStatus;
	
	public String getPropoId() {
		return propoId;
	}
	public void setPropoId(String propoId) {
		this.propoId = propoId;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public String getTravelFromPlace() {
		return travelFromPlace;
	}
	public void setTravelFromPlace(String travelFromPlace) {
		this.travelFromPlace = travelFromPlace;
	}
	public String getTravelToPlace() {
		return travelToPlace;
	}
	public void setTravelToPlace(String travelToPlace) {
		this.travelToPlace = travelToPlace;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getBeneficialName() {
		return beneficialName;
	}
	public void setBeneficialName(String beneficialName) {
		this.beneficialName = beneficialName;
	}
	public int getPropoStatus() {
		return propoStatus;
	}
	public void setPropoStatus(int propoStatus) {
		this.propoStatus = propoStatus;
	}
	public int getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(int payStatus) {
		this.payStatus = payStatus;
	}
	public int getClaimStatus() {
		return claimStatus;
	}
	public void setClaimStatus(int claimStatus) {
		this.claimStatus = claimStatus;
	}
	
	

}

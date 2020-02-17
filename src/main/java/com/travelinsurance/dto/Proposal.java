package com.travelinsurance.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Proposal {
	
	@Id
	private String pId;
	private String holderName;
	private Date dob;
	private String nrc;
	private String holderPhone;
	private String fromPlace;
	private String toPlace;
	private Date startDate;
	private Date endDate;
	private String vehicleNo;
	private double sumInsurance;
	private int proposalStatus;
	
	@ManyToOne
	private User user;
	
	@OneToMany(mappedBy = "proposalBenefit",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Beneficial> beneficial;
	
	@OneToOne(mappedBy = "proposalPayment",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private Payment payment;
	
	@ManyToOne
	private Plan plan;
	
	@ManyToOne
	private Vehicle vehicle;

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getNrc() {
		return nrc;
	}

	public void setNrc(String nrc) {
		this.nrc = nrc;
	}
	
	public String getHolderPhone() {
		return holderPhone;
	}

	public void setHolderPhone(String holderPhone) {
		this.holderPhone = holderPhone;
	}

	public String getFromPlace() {
		return fromPlace;
	}

	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}

	public String getToPlace() {
		return toPlace;
	}

	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
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

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public double getSumInsurance() {
		return sumInsurance;
	}

	public void setSumInsurance(double sumInsurance) {
		this.sumInsurance = sumInsurance;
	}

	public int getProposalStatus() {
		return proposalStatus;
	}

	public void setProposalStatus(int proposalStatus) {
		this.proposalStatus = proposalStatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Beneficial> getBeneficial() {
		return beneficial;
	}

	public void setBeneficial(List<Beneficial> beneficial) {
		this.beneficial = beneficial;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
}

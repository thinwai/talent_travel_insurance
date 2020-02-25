package com.travelinsurance.view_model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Future;
import javax.validation.constraints.Past;

import com.travelinsurance.dto.Beneficial;
import com.travelinsurance.dto.Payment;
import com.travelinsurance.dto.Proposal;
import com.travelinsurance.dto.User;

import lombok.Data;

@Data
public class UserProposalModel {
	
	private String pId;
	private String holderName;
	@Past
	private Date dob;
	private String holderNrc;
	private BigDecimal holderPhone;
	private String fromPlace;
	private String toPlace;
	@Future
	private Date startDate;
	private Date endDate;
	private String vehicleNo;
	private int unit;
	private int sumInsurance;
	private int proposalStatus;
	private User user;
	private List<Beneficial> beneficial;
	private Payment payment;
	private int plan;
	private int vehicle;
	
	private int bId;
	private String beneficialName;
	private String relationship;
	private String address;
	private String benificalNrc;
	private BigDecimal beneficialPh;
	private Proposal proposalBenefit;
	
	private String planType;
	private int planPrice;
	private String vehicleType;
	private String dobFormat;
	private String startDateFormat;
	private String endDateFormat;
	private int dateRange;
	private int message;
	
	//for detail List
	private int payId;
	private String bank;
	private String cardNo;
	private Date expiredDate;
	private String expiredDateFormat;
	private int payStatus;

	private int claimId;
	private String claimName;
	private String claimNrc;
	private BigDecimal claimPhone;
	private Date lostDate;
	private String lostDateFormat;
	private Double claimAmount;
	private String reason;
	private int claimStatus;
	
	private String claimType;
	
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
	public String getHolderNrc() {
		return holderNrc;
	}
	public void setHolderNrc(String holderNrc) {
		this.holderNrc = holderNrc;
	}
	public BigDecimal getHolderPhone() {
		return holderPhone;
	}
	public void setHolderPhone(BigDecimal holderPhone) {
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
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}
	public int getSumInsurance() {
		return sumInsurance;
	}
	public void setSumInsurance(int sumInsurance) {
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
	public int getPlan() {
		return plan;
	}
	public void setPlan(int plan) {
		this.plan = plan;
	}
	public int getVehicle() {
		return vehicle;
	}
	public void setVehicle(int vehicle) {
		this.vehicle = vehicle;
	}
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
	public String getBenificalNrc() {
		return benificalNrc;
	}
	public void setBenificalNrc(String benificalNrc) {
		this.benificalNrc = benificalNrc;
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
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getDobFormat() {
		return dobFormat;
	}
	public void setDobFormat(String dobFormat) {
		this.dobFormat = dobFormat;
	}
	public String getStartDateFormat() {
		return startDateFormat;
	}
	public void setStartDateFormat(String startDateFormat) {
		this.startDateFormat = startDateFormat;
	}
	public String getEndDateFormat() {
		return endDateFormat;
	}
	public void setEndDateFormat(String endDateFormat) {
		this.endDateFormat = endDateFormat;
	}
	public int getDateRange() {
		return dateRange;
	}
	public void setDateRange(int dateRange) {
		this.dateRange = dateRange;
	}
	public int getMessage() {
		return message;
	}
	public void setMessage(int message) {
		this.message = message;
	}
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
	public String getExpiredDateFormat() {
		return expiredDateFormat;
	}
	public void setExpiredDateFormat(String expiredDateFormat) {
		this.expiredDateFormat = expiredDateFormat;
	}
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
	public BigDecimal getClaimPhone() {
		return claimPhone;
	}
	public void setClaimPhone(BigDecimal claimPhone) {
		this.claimPhone = claimPhone;
	}
	public Date getLostDate() {
		return lostDate;
	}
	public void setLostDate(Date lostDate) {
		this.lostDate = lostDate;
	}
	public String getLostDateFormat() {
		return lostDateFormat;
	}
	public void setLostDateFormat(String lostDateFormat) {
		this.lostDateFormat = lostDateFormat;
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
	public String getClaimType() {
		return claimType;
	}
	public void setClaimType(String claimType) {
		this.claimType = claimType;
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

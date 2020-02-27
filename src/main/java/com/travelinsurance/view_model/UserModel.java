package com.travelinsurance.view_model;

import java.util.List;
import com.travelinsurance.dto.Proposal;

import lombok.Data;

@Data
public class UserModel {
	
	private int uId;
	private String email;
	private String username;
	private String password;
	private String conPassword;
	private int userAccStatus;
	private List<Proposal> proposals;
	private int totalPolicy;
	private int totalClaim;
	private int message;
	
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConPassword() {
		return conPassword;
	}
	public void setConPassword(String conPassword) {
		this.conPassword = conPassword;
	}
	public int getUserAccStatus() {
		return userAccStatus;
	}
	public void setUserAccStatus(int userAccStatus) {
		this.userAccStatus = userAccStatus;
	}
	public List<Proposal> getProposals() {
		return proposals;
	}
	public void setProposals(List<Proposal> proposals) {
		this.proposals = proposals;
	}
	public int getTotalPolicy() {
		return totalPolicy;
	}
	public void setTotalPolicy(int totalPolicy) {
		this.totalPolicy = totalPolicy;
	}
	public int getTotalClaim() {
		return totalClaim;
	}
	public void setTotalClaim(int totalClaim) {
		this.totalClaim = totalClaim;
	}
	public int getMessage() {
		return message;
	}
	public void setMessage(int message) {
		this.message = message;
	}

}

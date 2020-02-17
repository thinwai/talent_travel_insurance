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
	private int userAccStatus;
	private List<Proposal> proposals;

}

package com.travelinsurance.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.travelinsurance.dto.Plan;
import com.travelinsurance.dto.User;
import com.travelinsurance.dto.Vehicle;
import com.travelinsurance.service.BeneficialService;
import com.travelinsurance.service.PlanService;
import com.travelinsurance.service.ProposalService;
import com.travelinsurance.service.VehicleService;
import com.travelinsurance.util.MessagesUtil;
import com.travelinsurance.view_model.UserProposalModel;

@Named
@ViewScoped
public class ProposalController {
	
	@Autowired
	VehicleService vehicleService;
	
	@Autowired
	MessagesUtil msg;
	
	@Autowired
	PlanService planService;
	
	@Autowired
	ProposalService propoService;
	
	@Autowired
	private BeneficialService bService;
	
	private UserProposalModel uProposal=new UserProposalModel();
	private List<Vehicle> vehicles = new ArrayList<>();
	private List<Plan> plans=new ArrayList<>();
	
	public String proposal() {
		
		newProposal();
		
		return "proposalPage.xhtml?faces-redirect=true";
	}
	
	public String proposalNext() {
		
		return "beneficialPage.xhtml?faces-redirect=true";
	}
	
	public String saveProposal() {
		FacesContext facesContext=FacesContext.getCurrentInstance();
		HttpSession session=(HttpSession) facesContext.getExternalContext().getSession(true);
		
		User user=new User();
		user=(User) session.getAttribute("session");
		
		this.uProposal.setUser(user);
		propoService.saveProposal(uProposal);
		
		return "beneficialPage.xhtml";
	}
	
	/*
	public String saveProposal() {
		FacesContext facesContext=FacesContext.getCurrentInstance();
		HttpSession session=(HttpSession) facesContext.getExternalContext().getSession(true);
		
		User user=new User();
		user=(User) session.getAttribute("session");
		this.uProposal.setUser(user);
		
		propoService.saveProposal(uProposal);
		return "beneficialPage.xhtml";
	}
	
	public void beneficialSave() {
		bService.beneficialSave(uProposal);
		msg.messageInfo("Successfully Proposal Request!");
	}*/
	
	public void newProposal() {
		
		vehicles=vehicleService.findAllVehicle();
		plans=planService.findAllPlan();
		
		uProposal.setpId(msg.proposalId());
	}
	
	public String basicPlan() {
		newProposal();
		this.uProposal.setPlan(1);
		return "proposalPage.xhtml?faces-redirect=true";
	}
	
	public String advancePlan() {
		newProposal();
		this.uProposal.setPlan(2);
		return "proposalPage.xhtml?faces-redirect=true";
	}
	
	public String backToProposal() {
		
		return "proposalPage.xhtml?faces-redirect=true";
	}
	public String skipProposal() {
		
		return "homePage.xhtml?faces-redirect=true";
	}

	public UserProposalModel getuProposal() {
		return uProposal;
	}

	public void setuProposal(UserProposalModel uProposal) {
		this.uProposal = uProposal;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	public List<Plan> getPlans() {
		return plans;
	}
	public void setPlans(List<Plan> plans) {
		this.plans = plans;
	}
	
}

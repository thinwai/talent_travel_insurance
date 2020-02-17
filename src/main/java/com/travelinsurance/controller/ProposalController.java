package com.travelinsurance.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.travelinsurance.dto.Plan;
import com.travelinsurance.dto.Vehicle;
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
	
	private UserProposalModel uProposal=new UserProposalModel();
	private List<Vehicle> vehicles = new ArrayList<>();
	private List<Plan> plans=new ArrayList<>();
	
	public String proposal() {
		return "proposalPage.xhtml?faces-redirect=true";
	}
	
	public void test() {
		this.uProposal.setpId(msg.proposalId());
		propoService.saveProposal(uProposal);
		System.out.println("CONTROLLER PASS | "+uProposal.getVehicle());
		msg.messageWarn("Success");
	}
	@PostConstruct
	public void vehicle() {
		vehicles=vehicleService.findAllVehicle();
		plans=planService.findAllPlan();
		uProposal.setpId(msg.proposalId());
		
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

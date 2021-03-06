package com.travelinsurance.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.SlideEndEvent;
import org.springframework.beans.factory.annotation.Autowired;

import com.travelinsurance.dto.Plan;
import com.travelinsurance.dto.User;
import com.travelinsurance.dto.Vehicle;
import com.travelinsurance.service.ListService;
import com.travelinsurance.service.PlanService;
import com.travelinsurance.service.ProposalService;
import com.travelinsurance.service.VehicleService;
import com.travelinsurance.util.MessagesUtil;
import com.travelinsurance.view_model.ListModel;
import com.travelinsurance.view_model.SearchModel;
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
	private ListService listService;
	
	@Autowired
	ListController listController;

	private UserProposalModel uProposal = new UserProposalModel();
	private List<Vehicle> vehicles = new ArrayList<>();
	private List<Plan> plans = new ArrayList<>();

	public String proposal() {
		
		newProposal();

		return "proposalPage.xhtml?faces-redirect=true";
	}

	public String saveProposal() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);

		User user = new User();
		user = (User) session.getAttribute("session");

		this.uProposal.setUser(user);
		System.out.println(" Save ! " +uProposal.getpId());
		propoService.saveProposal(uProposal);

		uProposal.setMessage(1);
		System.out.println("message | "+uProposal.getMessage());

		return "proposalData.xhtml?faces-redirect=true";
	}

	/*
	 * public void beneficialSave() { bService.beneficialSave(uProposal);
	 * msg.messageInfo("Successfully Proposal Request!"); }
	 */

	public void newProposal() {
		uProposal=new UserProposalModel();
		vehicles = vehicleService.findAllVehicle();
		plans = planService.findAllPlan();
		
		try {
			if(this.uProposal.getpId().equals(null) || this.uProposal.getpId().equals("")) {
				uProposal.setpId(msg.proposalId());
			}
		}catch (Exception e) {
			uProposal.setpId(msg.proposalId());
		}
	}

	public String proposalNext() {

		uProposal.setDobFormat(msg.dateFormat(uProposal.getDob()));
		uProposal.setStartDateFormat(msg.dateFormat(uProposal.getStartDate()));
		uProposal.setEndDateFormat(msg.dateFormat(uProposal.getEndDate()));
		
		if(uProposal.getUnit() == 0 ) {
			uProposal.setUnit(1);
		}

		for (Plan temp : plans) {
			if (temp.getPlanId() == uProposal.getPlan()) {
				this.uProposal.setPlanType(temp.getPlanType());
				this.uProposal.setPlanPrice(temp.getPlanPrice());
				
				if(uProposal.getSumInsurance()==0) {
					this.uProposal.setSumInsurance( uProposal.getDateRange() * temp.getPlanPrice());
				}
			}
		}

		for (Vehicle temp : vehicles) {
			if (temp.getVehicleId() == uProposal.getVehicle()) {
				this.uProposal.setVehicleType(temp.getVehicleType());

			}
		}

		return "beneficialPage.xhtml?faces-redirect=true";
	}

	public void dateDiff(SelectEvent event) {
		
		Date startDate=uProposal.getStartDate();
		Date endDate=uProposal.getEndDate();
	
	     if(startDate!=null && endDate!=null){
	            //HH converts hour in 24 hours format (0-23), day calculation
	            SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	            
	            
	            long dateDiffValue = (long) 0;
	            
	
	            Date d1 = null;
	            Date d2 = null;
	
	            try {
	                d1 = startDate;
	                d2 = endDate;
	
	                //in milliseconds
	                long diff = d2.getTime() - d1.getTime();
	
	                long diffSeconds = diff / 1000 % 60;
	                long diffMinutes = diff / (60 * 1000) % 60;
	                long diffHours = diff / (60 * 60 * 1000) % 24;
	                long diffDays = diff / (24 * 60 * 60 * 1000);
	
	                // dateDiffValue=diffDays+"-"+diffHours+":"+diffMinutes+":"+diffSeconds;
	                
	                dateDiffValue=diffDays;
	
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
            System.out.println("date Range | "+dateDiffValue);
            this.uProposal.setDateRange((int)dateDiffValue+1);
	     }
	}
	
	public String showAllData(String propoId) {
		System.out.println(propoId);
		uProposal=listService.getAllData(propoId);
		uProposal.setViewStatus(1);
		
		return "proposalData.xhtml?faces-redirect=true";
	}
	
	public String proposalDataToList() {
		SearchModel searchModel=new SearchModel();
		searchModel.setSearchNo(2);
		searchModel.setSearchData(uProposal.getpId());
		listController.setSearchModel(searchModel); 												//Auto Only one list for this Proposal
		listController.list();
		uProposal = new UserProposalModel();
		
		return "listPage.xhtml?faces-redirect=true";
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

		return "proposalData.xhtml?faces-redirect=true";
	}

	public String showProposalData() {

		return "proposalData.xhtml?faces-redirect=true";
	}

	public String cancleProposal() {
		uProposal = new UserProposalModel();

		return "homePage.xhtml?faces-redirect=true";
	}
	
	public String editProposal(String propoId) {
		
		newProposal();
		
		uProposal=listService.getAllData(propoId);
		System.out.println("pro status : "+uProposal.getProposalStatus() + " | "+propoId +" | "+uProposal.getUnit() +" | "+uProposal.getSumInsurance());
		if(uProposal.getProposalStatus() == 1) {
			System.out.println("Edit Pass");
			
			return "proposalPage.xhtml?faces-redirect=true";
		}else if(uProposal.getProposalStatus() != 1){
			msg.messageError("You are not allowed to Edit!");
			
			ListModel listModel=new ListModel();
			listModel.setMessage(2);
			
			listController.setListModel(listModel);
			
			return null;
		}
		return null;
	}

	public void onSlideEnd(SlideEndEvent event) {

		System.out.println("ajax Test");
		this.uProposal.setSumInsurance(((int) event.getValue()) * uProposal.getPlanPrice() * uProposal.getDateRange());
		this.uProposal.setUnit((int) event.getValue());
		System.out.println(uProposal.getSumInsurance());
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

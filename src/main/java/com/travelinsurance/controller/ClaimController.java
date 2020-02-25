package com.travelinsurance.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.travelinsurance.dto.User;
import com.travelinsurance.service.ClaimService;
import com.travelinsurance.service.ListService;
import com.travelinsurance.service.PaymentService;
import com.travelinsurance.service.ProposalService;
import com.travelinsurance.util.MessagesUtil;
import com.travelinsurance.view_model.ClaimModel;
import com.travelinsurance.view_model.ClaimTypeModel;
import com.travelinsurance.view_model.ListModel;
import com.travelinsurance.view_model.SearchModel;
import com.travelinsurance.view_model.UserProposalModel;

@Named
@ViewScoped
public class ClaimController {
	
	@Autowired
	ProposalService propoService;
	
	@Autowired
	PaymentService payService;
	
	@Autowired
	ClaimService ctService;
	
	@Autowired
	MessagesUtil msg;

	private ClaimModel claimModel=new ClaimModel();
	private UserProposalModel propoModel=new UserProposalModel();
	private List<ClaimTypeModel> ctModel=new ArrayList<ClaimTypeModel>();
	
	public String claim() {
		return "claimPage.xhtml";
	}
	
	public String claimIdSave(){
		
		FacesContext facesContext=FacesContext.getCurrentInstance();
		HttpSession session=(HttpSession) facesContext.getExternalContext().getSession(true);
		
		User user=new User();
		user=(User) session.getAttribute("session");
		
		String propoId=claimModel.getPropoId();
		if(ctService.findClaimByPropoId(propoId) == 0) {
			
			System.out.println("____CONTROLLER____");
			try {
				propoModel=propoService.searchPropoId(propoId,user);
				if(propoModel.equals("") || propoModel.equals(null)) {
					msg.messageInfo("Your Proposal was not Exist!");
				}else {
					if(propoModel.getProposalStatus()==3) {
						
						boolean payStatusCheck=payService.searchPayment(propoId, true);
						if(payStatusCheck) {
							//msg.messageInfo("SUCCESS");
							ctModel=ctService.searchClaimType(propoModel.getPlan());
							return "claimFormPage.xhtml";
						}else {
							msg.messageInfo("Your Payment was not Exist!");
						}
					}else {
						msg.messageInfo("Your Proposal was not Accepted Our Company!");
					}
				}
			}catch (NullPointerException e) {
				msg.messageInfo("Your Proposal was not Exist!");
			}catch (Exception e) {
				msg.messageInfo("Error!");
				System.out.println(e);
			}
		}else {
			msg.messageInfo("Your Proposal was already Claim!");
		}
		return null;
	}
	
	public void claimSave() {
		
		int result=ctService.findToClaim(claimModel);
		
		for(ClaimTypeModel temp:ctModel) {
			if(temp.getCtId() == claimModel.getClaimType()){
				this.claimModel.setClaimTypeAmount(temp.getAmount());
			}
		}
		System.out.println("Amount of claim | "+claimModel.getClaimTypeAmount());
		if(result==0) {
			claimModel=ctService.saveClaim(claimModel);
			
			claimModel.setClaimMessage(1);
			//claimModel=new ClaimModel();
			msg.messageInfo("SUCCESS");
		}else if (result==1) {
			msg.messageInfo("Name must be policy holder Name or Beneficial Name!");
		}else if (result==2) {
			msg.messageInfo("Your Nrc no. is not Right!");
		}else if (result==3) {
			msg.messageInfo("Beneficial Nrc no. is not Right!");
		}else if(result==4) {
			msg.messageInfo("Lost_Date Must Be Your Duration of Your Travelling Date");
		}
	}
	
	public String claimToListPage() {
		
		claimModel=new ClaimModel();
		
		return "listPage.xhtml";
	}
	
	/*
	public String claimIdSave(){
		
		String propoId=claimModel.getPropoId();
		boolean propoIdCheck=propoService.searchPropoId(propoId, false);
		if(propoIdCheck) {																				//propoID Exist?
			boolean propoStatusCheck=propoService.searchPropoId(propoId, true);
			
			if(propoStatusCheck) {																		//proposal Accecpt?
				boolean payCheck=payService.searchPayment(propoId, false);
				
				if(payCheck){
					boolean payStatusCheck=payService.searchPayment(propoId, true);
					
					if(payStatusCheck) {
						msg.messageInfo("SUCCESS");
						return "claimPage2.xhtml";
					}else {
						msg.messageInfo("Your Payment was not Accepted!");
					}
				}else {
					msg.messageInfo("Your Payment was not Exist!");
				}
			}else {
				msg.messageInfo("Your Proposal was not Accepted Our Company!");
			}
		}else {
			msg.messageInfo("Your Proposal was not Exist!");
		}
		return null;
	}
	
	/*
	public void claimIdSave(){
		System.out.println(claimModel.getPropoId());
		boolean propoIdCheck=propoService.searchPropoId(claimModel.getPropoId(), false);
		if(propoIdCheck) {																				//propoID Exist?
			boolean propoStatusCheck=propoService.searchPropoId(claimModel.getPropoId(), true);
			if(propoStatusCheck) {																		//proposal Accecpt?
				msg.messageInfo("SUCCESS");
			}else {
				msg.messageInfo("Your Proposal did not Accept Our Company!");
			}
		}else {
			msg.messageInfo("Your Proposal Does not Exist!");
		}
		
	}*/

	public ClaimModel getClaimModel() {
		return claimModel;
	}

	public void setClaimModel(ClaimModel claimModel) {
		this.claimModel = claimModel;
	}

	public UserProposalModel getPropoModel() {
		return propoModel;
	}

	public void setPropoModel(UserProposalModel propoModel) {
		this.propoModel = propoModel;
	}

	public List<ClaimTypeModel> getCtModel() {
		return ctModel;
	}

	public void setCtModel(List<ClaimTypeModel> ctModel) {
		this.ctModel = ctModel;
	}
}
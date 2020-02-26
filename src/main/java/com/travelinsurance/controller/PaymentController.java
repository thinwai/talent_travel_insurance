package com.travelinsurance.controller;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.travelinsurance.dto.User;
import com.travelinsurance.service.PaymentService;
import com.travelinsurance.service.ProposalService;
import com.travelinsurance.util.MessagesUtil;
import com.travelinsurance.view_model.ClaimModel;
import com.travelinsurance.view_model.PaymentModel;
import com.travelinsurance.view_model.UserProposalModel;

@Named
@ViewScoped
public class PaymentController {
	
	@Autowired
	PaymentService payService;
	
	@Autowired
	ProposalService propoService;
	
	@Autowired
	MessagesUtil msg;
	
	private PaymentModel payment=new PaymentModel();
	private UserProposalModel propoModel=new UserProposalModel();
	
	public String payment() {
		return "paymentPage.xhtml";
	}
	
	public String payIdSave() {
		
		FacesContext facesContext=FacesContext.getCurrentInstance();
		HttpSession session=(HttpSession) facesContext.getExternalContext().getSession(true);
		
		User user=new User();
		user=(User) session.getAttribute("session");
		String propoId=payment.getProposalPayment();
		if(!payService.searchPayment(propoId, true)) {
			try {
				propoModel=propoService.searchPropoId(propoId,user);
				if(propoModel.equals("") || propoModel.equals(null)) {
					msg.messageInfo("Your Proposal was not Exist!");
				}else {
					if(propoModel.getProposalStatus()==3) {
						
						//msg.messageInfo("Success");
						return "paymentFormPage.xhtml";
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
			msg.messageInfo("You have already Pay for this Proposal!");
		}
		return null;
	}
	
	public void paySave() {
		int result=payService.save(payment);
		
		if(result==1) {
			msg.messageInfo("You have already waiting for this Payment!");
			
		}else if(result==2) {
			msg.messageInfo("Successfully Re.payment Request!");
		}else if(result==3) {
			msg.messageInfo("Successfully Payment Request!");
		}
		payment=new PaymentModel();
	}
	
	public PaymentModel getPayment() {
		return payment;
	}

	public void setPayment(PaymentModel payment) {
		this.payment = payment;
	}

	public UserProposalModel getPropoModel() {
		return propoModel;
	}

	public void setPropoModel(UserProposalModel propoModel) {
		this.propoModel = propoModel;
	}
}

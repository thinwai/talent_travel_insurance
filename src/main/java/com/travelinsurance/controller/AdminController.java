package com.travelinsurance.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.travelinsurance.dto.Beneficial;
import com.travelinsurance.dto.Plan;
import com.travelinsurance.dto.Proposal;
import com.travelinsurance.dto.User;
import com.travelinsurance.dto.Vehicle;
import com.travelinsurance.repository.BeneficialRepository;
import com.travelinsurance.repository.ProposalRepository;
import com.travelinsurance.service.AdminService;
import com.travelinsurance.service.ProposalService;
import com.travelinsurance.view_model.AdminControlModel;

@Named
@ViewScoped
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	ProposalRepository propoRepo;
	
	@Autowired
	BeneficialRepository bRepo;
	
	private List<AdminControlModel> adminModelList=new ArrayList<AdminControlModel>();
	
	
	public void proposalRequest() {
		adminModelList=adminService.proposalRequest();
	}
	
	public void proposalAccept(String propoId, int requestStatus) {
		
		System.out.println("request Status | "+requestStatus);
		
		for(AdminControlModel temp:adminModelList) {
			if(temp.getpId().equals(propoId)) {
				
				Proposal propo=new Proposal();
				
				propo.setpId(temp.getpId());
				propo.setHolderName(temp.getHolderName());
				propo.setDob(temp.getDob());
				propo.setNrc(temp.getHolderNrc());
				propo.setHolderPhone(temp.getHolderPhone());
				propo.setFromPlace(temp.getFromPlace());
				propo.setToPlace(temp.getToPlace());
				propo.setStartDate(temp.getStartDate());
				propo.setEndDate(temp.getEndDate());
				propo.setDuration(temp.getDateRange());
				propo.setVehicleNo(temp.getVehicleNo());
				propo.setUnit(temp.getUnit());
				propo.setSumInsurance(temp.getSumInsurance());
				
				if(requestStatus==3) {
					propo.setProposalStatus(3);
				}else if(requestStatus==2) {
					propo.setProposalStatus(2);
				}
				propo.setStatus(1);
				
				propo.setUser(temp.getUser());
				Vehicle v=new Vehicle();
				v.setVehicleId(temp.getVehicle());
				
				propo.setVehicle(v);
				
				Plan p=new Plan();
				p.setPlanId(temp.getPlan());
				
				propo.setPlan(p);
				
				User user=new User();
				user=temp.getUser();
				propo.setUser(user);
				
				propoRepo.save(propo);
				
				System.out.println("beni");
				try {
					if(!temp.getBeneficialName().equals(null)) {
						Beneficial beneficialdto = new Beneficial();
						beneficialdto.setbId(temp.getbId());
						beneficialdto.setBeneficialName(temp.getBeneficialName());
						beneficialdto.setNrc(temp.getBenificalNrc());
						beneficialdto.setRelationship(temp.getRelationship());
						beneficialdto.setBeneficialPh(temp.getBeneficialPh());
						beneficialdto.setAddress(temp.getAddress());
						beneficialdto.setProposalBenefit(propo);
						
						bRepo.save(beneficialdto);
						
						System.out.println("exist beni");
					}
				}catch (Exception e) {
					System.out.println("null beni");
				}
			}
		}
		proposalRequest();
	}
	
	

	public List<AdminControlModel> getAdminModelList() {
		return adminModelList;
	}

	public void setAdminModelList(List<AdminControlModel> adminModelList) {
		this.adminModelList = adminModelList;
	}
}

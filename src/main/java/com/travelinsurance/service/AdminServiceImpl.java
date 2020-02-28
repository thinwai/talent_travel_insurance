package com.travelinsurance.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelinsurance.dto.Proposal;
import com.travelinsurance.dto.User;
import com.travelinsurance.repository.BeneficialRepository;
import com.travelinsurance.repository.ProposalRepository;
import com.travelinsurance.util.MessagesUtil;
import com.travelinsurance.view_model.AdminControlModel;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	ProposalRepository propoRepo;
	
	@Autowired
	BeneficialRepository bRepo;
	
	@Autowired
	MessagesUtil msg;
	
	@Override
	public List<AdminControlModel> proposalRequest() {
		
		List<Proposal> result=propoRepo.proposalRequest();
		
		List<AdminControlModel> propoModel=new ArrayList<AdminControlModel>();
		
		for (Proposal temp:result) {
			
			AdminControlModel listModel= new AdminControlModel();
			
			listModel.setpId(temp.getpId());
			listModel.setHolderName(temp.getHolderName());
			listModel.setDob(temp.getDob());						//dob
			listModel.setDobFormat(msg.dateFormat(temp.getDob()));	//format
			listModel.setHolderNrc(temp.getNrc());
			listModel.setHolderPhone(temp.getHolderPhone());
			listModel.setFromPlace(temp.getFromPlace());
			listModel.setToPlace(temp.getToPlace());
			
			listModel.setStartDate(temp.getStartDate());						//start date
			listModel.setStartDateFormat(msg.dateFormat(temp.getStartDate())); //format
			listModel.setEndDate(temp.getEndDate());							//end date
			listModel.setEndDateFormat(msg.dateFormat(temp.getEndDate()));		//format
			listModel.setDateRange(temp.getDuration());
			
			listModel.setVehicleNo(temp.getVehicleNo());
			listModel.setUnit(temp.getUnit());
			listModel.setSumInsurance(temp.getSumInsurance());
			listModel.setProposalStatus(temp.getProposalStatus());
			listModel.setPlan(temp.getPlan().getPlanId());
			listModel.setPlanType(temp.getPlan().getPlanType());
			listModel.setPlanPrice(temp.getPlan().getPlanPrice());
			listModel.setVehicle(temp.getVehicle().getVehicleId());
			listModel.setVehicleType(temp.getVehicle().getVehicleType());
			
			User user=new User();
			user=temp.getUser();
			listModel.setUser(user);
			
//			
//			List<Beneficial> bList=new ArrayList<Beneficial>();
//			if(!temp.getBeneficial().isEmpty()) {
//				
//				
//				for(int i=0; i<temp.getBeneficial().size(); i++) {
//					
//					Beneficial bf=new Beneficial();
//					
//					bf.setbId(temp.getBeneficial().get(i).getbId());
//					bf.setBeneficialName(temp.getBeneficial().get(i).getBeneficialName());
//					bf.setBeneficialPh(temp.getBeneficial().get(i).getBeneficialPh());
//					bf.setAddress(temp.getBeneficial().get(i).getAddress());
//					bf.setNrc(temp.getBeneficial().get(i).getNrc());
//					bf.setRelationship(temp.getBeneficial().get(i).getRelationship());
//					
//					System.out.println("b1 "+ i +temp.getBeneficial().get(i).getBeneficialName());
//					bList.add(bf);
//				}
//				System.out.println(bList);
//				listModel.setBeneficial(bList);
//			}else {
//				listModel.setBeneficial(bList);
//			}
//			
			propoModel.add(listModel);
		}
		
		return propoModel;
	}

}

package com.travelinsurance.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelinsurance.dto.Beneficial;
import com.travelinsurance.dto.Proposal;
import com.travelinsurance.dto.User;
import com.travelinsurance.repository.ListRepository;
import com.travelinsurance.repository.ProposalRepository;
import com.travelinsurance.util.MessagesUtil;
import com.travelinsurance.view_model.ListModel;
import com.travelinsurance.view_model.SearchModel;
import com.travelinsurance.view_model.UserProposalModel;

@Service
public class ListServiceImpl implements ListService{
	
	@Autowired
	ListRepository listRepo;
	
	@Autowired
	ProposalRepository propoRepo;
	
	@Autowired
	MessagesUtil msg;

	@Override
	public List<ListModel> detailList(User user, SearchModel search) {

		List<Proposal> propo=listRepo.viewList(user,search);
		
		List<ListModel> list = new ArrayList<ListModel>();
		
		for (Proposal temp:propo) {
			
			ListModel listModel= new ListModel();
			
			listModel.setPropoId(temp.getpId());
			listModel.setHolderName(temp.getHolderName());
			listModel.setTravelFromPlace(temp.getFromPlace());
			listModel.setTravelToPlace(temp.getToPlace());
			listModel.setStartDate(msg.dateFormat(temp.getStartDate()));
			listModel.setEndDate(msg.dateFormat(temp.getEndDate()));
			listModel.setPropoStatus(temp.getProposalStatus());
			
			List<Beneficial> bList=new ArrayList<Beneficial>();
			if(!temp.getBeneficial().isEmpty()) {
				
				
				for(int i=0; i<temp.getBeneficial().size(); i++) {
					
					Beneficial bf=new Beneficial();
					
					bf.setbId(temp.getBeneficial().get(i).getbId());
					bf.setBeneficialName(temp.getBeneficial().get(i).getBeneficialName());
					bf.setBeneficialPh(temp.getBeneficial().get(i).getBeneficialPh());
					bf.setAddress(temp.getBeneficial().get(i).getAddress());
					bf.setNrc(temp.getBeneficial().get(i).getNrc());
					bf.setRelationship(temp.getBeneficial().get(i).getRelationship());
					
					System.out.println("b1 "+ i +temp.getBeneficial().get(i).getBeneficialName());
					bList.add(bf);
				}
				System.out.println(bList);
				listModel.setBeneficial(bList);
			}else {
				listModel.setBeneficial(bList);
			}
			
			try {
				listModel.setPayStatus(temp.getPayment().getPayStatus());
			}catch (Exception e) {
				listModel.setPayStatus(0);
			}
			System.out.println("List 1");
			try {
				listModel.setClaimStatus(temp.getPayment().getClaim().getClaimStatus());System.out.println("List 2");
			}catch (Exception e) {System.out.println("List 3 |"+e);
				listModel.setClaimStatus(0);
			}
			
			list.add(listModel);
		}
		return list;
	}

	@Override
	public Boolean deleteProposal(String id) {
		
		Boolean result;
		
		Proposal propo= new Proposal();
		propo=propoRepo.searchProId(id);
		
		if(propo.getProposalStatus()!=3) {
			propo.setStatus(2);
			System.out.println("Service ____________"+id);
			
			propoRepo.save(propo);
			
			result=true;
		}else {
			result=false;
		}
		
		return result;
	}

	@Override
	public UserProposalModel getAllData(String propoId) {
		
		Proposal result=listRepo.searchAllDetail(propoId);
		
		UserProposalModel proModel=new UserProposalModel();
		
		//start proposal
		proModel.setpId(result.getpId());
		proModel.setHolderName(result.getHolderName());
		proModel.setDob(result.getDob());						//dob
		proModel.setDobFormat(msg.dateFormat(result.getDob()));	//format
		proModel.setHolderNrc(result.getNrc());
		proModel.setHolderPhone(result.getHolderPhone());
		proModel.setFromPlace(result.getFromPlace());
		proModel.setToPlace(result.getToPlace());
		
		proModel.setStartDate(result.getStartDate());						//start date
		proModel.setStartDateFormat(msg.dateFormat(result.getStartDate())); //format
		proModel.setEndDate(result.getEndDate());							//end date
		proModel.setEndDateFormat(msg.dateFormat(result.getEndDate()));		//format
		proModel.setDateRange(result.getDuration());
		
		proModel.setVehicleNo(result.getVehicleNo());
		proModel.setUnit(result.getUnit());System.out.println(result.getUnit() + " | "+proModel.getUnit());
		proModel.setSumInsurance(result.getSumInsurance());
		proModel.setProposalStatus(result.getProposalStatus());
		proModel.setPlan(result.getPlan().getPlanId());
		proModel.setPlanType(result.getPlan().getPlanType());
		proModel.setPlanPrice(result.getPlan().getPlanPrice());
		proModel.setVehicle(result.getVehicle().getVehicleId());
		proModel.setVehicleType(result.getVehicle().getVehicleType());
		//end proposal
		System.out.println("1");
		//start beneficial
		
		try {
			if(!result.getBeneficial().isEmpty()) {
				System.out.println("1.1");
				proModel.setbId(result.getBeneficial().get(0).getbId());
				proModel.setBeneficialName(result.getBeneficial().get(0).getBeneficialName());
				proModel.setBeneficialPh(result.getBeneficial().get(0).getBeneficialPh());
				proModel.setAddress(result.getBeneficial().get(0).getAddress());
				proModel.setBenificalNrc(result.getBeneficial().get(0).getNrc());
				proModel.setRelationship(result.getBeneficial().get(0).getRelationship());
				
			}else {
				proModel.setbId(0);
			}
		}catch (Exception e) {
			System.out.println("1.1 | " +e);
		}
		//end beneficial
		System.out.println("2");
		//start payment
		try {
			proModel.setPayId(result.getPayment().getPayId());
			proModel.setBank(result.getPayment().getBank());
			proModel.setCardNo(result.getPayment().getCardNo());
			proModel.setExpiredDate(result.getPayment().getExpiredDate());								//date
			proModel.setExpiredDateFormat(msg.dateFormat(result.getPayment().getExpiredDate()));		//format
			proModel.setPayStatus(result.getPayment().getPayStatus());
			
		}catch (Exception e) {
			proModel.setPayStatus(0);
		}
		System.out.println("3");
		//start claim
		try {
			proModel.setClaimId(result.getPayment().getClaim().getClaimId());
			proModel.setClaimName(result.getPayment().getClaim().getClaimName());
			proModel.setClaimNrc(result.getPayment().getClaim().getClaimNrc());
			proModel.setClaimPhone(result.getPayment().getClaim().getClaimPhone());
			proModel.setLostDate(result.getPayment().getClaim().getLostDate());				//date
			proModel.setLostDateFormat(msg.dateFormat(result.getPayment().getClaim().getLostDate())); //format
			proModel.setClaimAmount(result.getPayment().getClaim().getClaimAmount());
			proModel.setReason(result.getPayment().getClaim().getReason());
			proModel.setClaimStatus(result.getPayment().getClaim().getClaimStatus());
			
			//proModel.setClaimType(result.getPayment().getClaim().getClaimType().getClaimType());
		}catch (Exception e) {
			proModel.setClaimStatus(0);
		}
		System.out.println("4");
		return proModel;
	}
}

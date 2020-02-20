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
			
			if(!temp.getBeneficial().isEmpty()) {
				listModel.setBeneficialName(temp.getBeneficial().get(0).getBeneficialName());
			}else {
				listModel.setBeneficialName("");
			}
			
			//listModel.setBeneficialName(temp.getBeneficial().get(0).getBeneficialName());
			/*
			List<Beneficial>beni=temp.getBeneficial();
			for (Beneficial benetemp:beni) {
				listModel.setBeneficialName(benetemp.getBeneficialName());
			}
			*/
			listModel.setPropoStatus(temp.getProposalStatus());
			
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
	public void deleteProposal(String id) {
		
		Proposal propo= new Proposal();
		propo=propoRepo.searchProId(id);
		
		propo.setStatus(2);
		System.out.println("Service ____________"+id);
		
		propoRepo.save(propo);
		
	}

}

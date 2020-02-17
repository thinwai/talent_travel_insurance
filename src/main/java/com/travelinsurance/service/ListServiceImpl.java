package com.travelinsurance.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelinsurance.dto.Beneficial;
import com.travelinsurance.dto.Proposal;
import com.travelinsurance.dto.User;
import com.travelinsurance.repository.ListRepository;
import com.travelinsurance.view_model.ListModel;
import com.travelinsurance.view_model.SearchModel;

@Service
public class ListServiceImpl implements ListService{
	
	@Autowired
	ListRepository listRepo;

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
			listModel.setStartDate(temp.getStartDate());
			listModel.setEndDate(temp.getEndDate());
			//listModel.setBeneficialName(temp.getBeneficial().get(0).getBeneficialName());
			/*
			List<Beneficial>beni=temp.getBeneficial();
			for (Beneficial benetemp:beni) {
				listModel.setBeneficialName(benetemp.getBeneficialName());
			}
			*/
			listModel.setPropoStatus(temp.getProposalStatus());
			listModel.setPayStatus(temp.getPayment().getPayStatus());
			listModel.setClaimStatus(temp.getPayment().getClaim().getClaimStatus());
			
			list.add(listModel);
		}
		return list;
	}

}

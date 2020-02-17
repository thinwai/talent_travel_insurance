package com.travelinsurance.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.travelinsurance.dto.User;
import com.travelinsurance.service.ListService;
import com.travelinsurance.view_model.ListModel;

@Named
@ViewScoped
public class ListController {
	
	private ListModel detailList =new ListModel();
	private List<ListModel> listModels=new ArrayList<ListModel>();
	
	private List<ListModel> filteredList;
	
	@Autowired
	ListService listService;
	
	public String list() {
		return "listPage.xhtml?faces-redirect=true";
	}
	
	//@PostConstruct
	public void viewList() {
		User user=new User();
		user.setuId(1);
		user.setEmail("aa@gmail.com");
		listModels=listService.detailList(user);
	}
	
	public boolean globalFilterFunction(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim().toLowerCase();
        if (filterText == null || filterText.equals("")) {
            return true;
        }
 
        ListModel listModel = (ListModel) value;
        return listModel.getPropoId().toLowerCase().contains(filterText)
                || listModel.getHolderName().toLowerCase().contains(filterText)
                || listModel.getTravelFromPlace().toLowerCase().contains(filterText)
                || listModel.getTravelToPlace().toLowerCase().contains(filterText)
                
                || listModel.getBeneficialName().toLowerCase().contains(filterText);
    }


	public ListModel getDetailList() {
		return detailList;
	}

	public void setDetailList(ListModel detailList) {
		this.detailList = detailList;
	}

	public List<ListModel> getListModels() {
		return listModels;
	}

	public void setListModels(List<ListModel> listModels) {
		this.listModels = listModels;
	}

	public List<ListModel> getFilteredList() {
		return filteredList;
	}

	public void setFilteredList(List<ListModel> filteredList) {
		this.filteredList = filteredList;
	}
	
	

}

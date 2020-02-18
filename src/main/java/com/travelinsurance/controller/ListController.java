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
import com.travelinsurance.view_model.SearchModel;

@Named
@ViewScoped
public class ListController {
	
	private SearchModel searchModel =new SearchModel();
	private List<ListModel> listModels=new ArrayList<ListModel>();
	
	
	@Autowired
	ListService listService;
	
	public String list() {
		return "listPage.xhtml?faces-redirect=true";
	}
	
	@PostConstruct
	public void viewList() {
		User user=new User();
		user.setuId(1);
		user.setEmail("aa@gmail.com");
		
		System.out.println("searchNo |"+searchModel.getSearchNo());
		System.out.println("searchData |"+searchModel.getSearchData());
		
		System.out.println(searchModel);
		
		listModels=listService.detailList(user,searchModel);
		
		searchModel=new SearchModel();
	}
	
	/**/

	public List<ListModel> getListModels() {
		return listModels;
	}

	public SearchModel getSearchModel() {
		return searchModel;
	}

	public void setSearchModel(SearchModel searchModel) {
		this.searchModel = searchModel;
	}

	public void setListModels(List<ListModel> listModels) {
		this.listModels = listModels;
	}
	

}

package com.travelinsurance.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.travelinsurance.dto.User;
import com.travelinsurance.service.ListService;
import com.travelinsurance.util.MessagesUtil;
import com.travelinsurance.view_model.ListModel;
import com.travelinsurance.view_model.SearchModel;

@Named
@ViewScoped
public class ListController {
	
	private SearchModel searchModel =new SearchModel();
	private List<ListModel> listModels=new ArrayList<ListModel>();
	private ListModel listModel=new ListModel();
	
	@Autowired
	ListService listService;
	
	@Autowired
	MessagesUtil msg;
	
	public String list() {
		
		this.listModel.setMessage(0);
		
		FacesContext facesContext=FacesContext.getCurrentInstance();
		HttpSession session=(HttpSession) facesContext.getExternalContext().getSession(true);
		
		User user=new User();
		user=(User) session.getAttribute("session");
		
		listModels=listService.detailList(user,searchModel);
		
		return "listPage.xhtml";
	}
	
	public void listReset() {
		
		searchModel=new SearchModel();
		
		searchModel.setSearchNo(1);
		list();
		
	}
	
	public void deleteProposal(String Id) {
		
		Boolean result=listService.deleteProposal(Id);
		System.out.println("delete message test 1 ");
		if(result) {
			list();
			System.out.println("delete message test 2 ");
			msg.messageInfo("Successfully DELETE!");
			this.listModel.setMessage(1);
		}else {
			System.out.println("delete message test 3 ");
			msg.messageInfo("Your Proposal are not allowed to DELETE!");
			this.listModel.setMessage(2);
		}
		System.out.println("delete message test 4 ");
	}

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

	public ListModel getListModel() {
		return listModel;
	}

	public void setListModel(ListModel listModel) {
		this.listModel = listModel;
	}
	

}

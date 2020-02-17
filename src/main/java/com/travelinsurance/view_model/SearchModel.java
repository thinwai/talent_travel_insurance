package com.travelinsurance.view_model;

import lombok.Data;

@Data
public class SearchModel {
	private int searchNo;
	private String searchData;
	public int getSearchNo() {
		return searchNo;
	}
	public void setSearchNo(int searchNo) {
		this.searchNo = searchNo;
	}
	public String getSearchData() {
		return searchData;
	}
	public void setSearchData(String searchData) {
		this.searchData = searchData;
	}
	
	

}

package com.travelinsurance.service;

import java.util.List;

import com.travelinsurance.dto.User;
import com.travelinsurance.view_model.ListModel;

public interface ListService {
	
	List<ListModel> detailList(User user);

}

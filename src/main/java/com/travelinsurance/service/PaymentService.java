package com.travelinsurance.service;

import com.travelinsurance.view_model.PaymentModel;

public interface PaymentService {

	Boolean searchPayment(String propoId, boolean statusCheck);
	void save(PaymentModel payModel);
}

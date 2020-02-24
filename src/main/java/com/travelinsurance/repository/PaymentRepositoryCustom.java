package com.travelinsurance.repository;

import com.travelinsurance.dto.Payment;

public interface PaymentRepositoryCustom {
	
	Payment searchPayment(String propoId, boolean status);
	Payment searchByProposalId(String propoId);

}

package com.travelinsurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travelinsurance.dto.Proposal;

public interface MyAccountRepository extends JpaRepository<Proposal, String> , MyAccountRepositoryCustom{
	

}

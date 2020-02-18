package com.travelinsurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travelinsurance.dto.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Integer>, ClaimRepositoryCustom{

}

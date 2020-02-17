package com.travelinsurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travelinsurance.dto.ClaimType;

public interface ClaimTypeRepository extends JpaRepository<ClaimType, Integer>,ClaimTypeRepositoryCustom{

}

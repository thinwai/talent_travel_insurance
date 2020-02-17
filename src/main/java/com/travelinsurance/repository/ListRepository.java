package com.travelinsurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travelinsurance.dto.Proposal;

public interface ListRepository extends JpaRepository<Proposal, String>, ListRepositoryCustom{

}

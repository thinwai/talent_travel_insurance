package com.travelinsurance.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.travelinsurance.dto.Claim;
import com.travelinsurance.dto.Payment;
import com.travelinsurance.dto.Proposal;

@Repository
public class ClaimRepositoryImpl implements ClaimRepositoryCustom{
	
	@Autowired
	EntityManager em;

	@Override
	public Integer findClaimByProposalId(String propoId) {
		try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
	        CriteriaQuery<Proposal> cq = cb.createQuery(Proposal.class);
	 
	        Root<Proposal> proposal = cq.from(Proposal.class);
	        Fetch<Proposal, Payment> proposalPayment=proposal.fetch("payment", JoinType.INNER);
	        Fetch<Payment, Claim> claim=proposalPayment.fetch("claim", JoinType.INNER);
	        
	        Predicate proposalPredicate = cb.equal(proposal.get("pId"), propoId);
	        Predicate propoStatus= cb.equal(proposal.get("proposalStatus"), 3);
	        Predicate paymentStatus= cb.equal(((Path<Proposal>) proposalPayment).get("payStatus"), 3);
	        cq.where(cb.and(proposalPredicate, propoStatus, paymentStatus)).distinct(true);
	 
	        List<Proposal> result = em.createQuery(cq).getResultList();
	        System.out.println("Find Claim Repo | "+result.size());
			return result.size();
		}catch (Exception e) {
			System.out.println("Find Claim Repo Error | ");
			return 0;
		}
	}

}

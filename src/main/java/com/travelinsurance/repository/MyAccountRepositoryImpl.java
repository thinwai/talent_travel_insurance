package com.travelinsurance.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
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
import com.travelinsurance.dto.User;

@Repository
public class MyAccountRepositoryImpl implements MyAccountRepositoryCustom {

	@Autowired
	EntityManager em;

	@Override
	public Integer findTotalpolicy(User user) {
		try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
	        CriteriaQuery<Proposal> cq = cb.createQuery(Proposal.class);
	 
	        Root<Proposal> proposal = cq.from(Proposal.class);
	        Fetch<Proposal, Payment> proposalPayment=proposal.fetch("payment", JoinType.INNER);
	        
	        Predicate proposalPredicate = cb.equal(proposal.get("user"), user.getuId());
	        Predicate propoStatus= cb.equal(proposal.get("proposalStatus"), 3);
	        Predicate paymentStatus= cb.equal(((Path<Proposal>) proposalPayment).get("payStatus"), 3);
	        cq.where(cb.and(proposalPredicate, propoStatus, paymentStatus)).distinct(true);
	 
	        List<Proposal> result = em.createQuery(cq).getResultList();
	        
			return result.size();
		}catch (Exception e) {
			return 0;
		}
	}

	@Override
	public Integer findTotalClaim(User user) {
		
		try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
	        CriteriaQuery<Proposal> cq = cb.createQuery(Proposal.class);
	 
	        Root<Proposal> proposal = cq.from(Proposal.class);
	        Fetch<Proposal, Payment> proposalPayment=proposal.fetch("payment", JoinType.INNER);
	        Fetch<Payment, Claim> claim=proposalPayment.fetch("claim", JoinType.INNER);
	        
	        Predicate proposalPredicate = cb.equal(proposal.get("user"), user.getuId());
	        Predicate propoStatus= cb.equal(proposal.get("proposalStatus"), 3);
	        Predicate paymentStatus= cb.equal(((Path<Proposal>) proposalPayment).get("payStatus"), 3);
	        Predicate claimPredicate= cb.equal(((Path<Proposal>) claim).get("claimStatus"), 3);
	        cq.where(cb.and(proposalPredicate, propoStatus, paymentStatus,claimPredicate)).distinct(true);
	 
	        List<Proposal> result = em.createQuery(cq).getResultList();
	        
			return result.size();
		}catch (Exception e) {
			return 0;
		}
	}

	/*
	@Override
	public Long totalPolicy(User user) {
		Long result=(long) 0;
		
		try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
	        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
	 
	        Root<Proposal> proposal = cq.from(Proposal.class);
	        //Fetch<Proposal, Payment> proposalPayment=proposal.fetch("payment", JoinType.INNER);
	        
	        Predicate proposalPredicate = cb.equal(proposal.get("user"), user.getuId());
	        System.out.println("1");
	        Predicate propoStatus= cb.equal(proposal.get("proposalStatus"), 3);
	        System.out.println("2");
	        //Predicate paymentStatus= cb.equal(((Path<Proposal>) proposalPayment).get("payStatus"), 3);
	        System.out.println("3");
	
	        cq.select(cb.countDistinct(cq.from(Proposal.class)));
	        System.out.println("4");
	        //cq.where(proposalPredicate);
	        cq.where(cb.and(proposalPredicate, propoStatus)).distinct(true);
	        System.out.println("5");
	 
	        result = em.createQuery(cq).getSingleResult();
	        System.out.println("6");
	        
	        System.out.println("Repo Result ||| "+result);
		}catch (Exception e) {
			 System.out.println("Repo Result error||| "+e);
		}
		return result;
	}
	*/

	
	


	
}

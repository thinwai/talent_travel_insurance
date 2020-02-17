package com.travelinsurance.repository;

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

import com.travelinsurance.dto.Payment;
import com.travelinsurance.dto.Proposal;
import com.travelinsurance.dto.User;

@Repository
public class MyAccountRepositoryImpl implements MyAccountRepositoryCustom {

	@Autowired
	EntityManager em;

	@Override
	public Long totalPolicy(User user) {
		Long result=(long) 0;
		
		try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
	        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
	 
	        Root<Proposal> proposal = cq.from(Proposal.class);
	        Fetch<Proposal, Payment> proposalPayment=proposal.fetch("payment", JoinType.LEFT);
	        
	        Predicate proposalPredicate = cb.equal(proposal.get("user"), user.getuId());
	        System.out.println("1");
	        Predicate propoStatus= cb.equal(proposal.get("proposalStatus"), 3);
	        System.out.println("2");
	        Predicate paymentStatus= cb.equal(((Path<Proposal>) proposalPayment).get("payStatus"), 3);
	        System.out.println("3");
	
	        cq.select(cb.countDistinct(cq.from(Proposal.class)));
	        System.out.println("4");
	        //cq.where(proposalPredicate);
	        cq.where(cb.and(proposalPredicate, propoStatus, paymentStatus)).distinct(true);
	        System.out.println("5");
	 
	        result = em.createQuery(cq).getSingleResult();
	        System.out.println("6");
	        
	        System.out.println("Repo Result ||| "+result);
		}catch (Exception e) {
			 System.out.println("Repo Result error||| "+e);
		}
		return result;
	}
	


	
}

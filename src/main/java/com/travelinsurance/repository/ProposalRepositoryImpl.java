package com.travelinsurance.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.travelinsurance.dto.Proposal;
import com.travelinsurance.dto.User;

@Repository
public class ProposalRepositoryImpl implements ProposalRepositoryCustom{
	
	@Autowired
	EntityManager em;

	@Override
	public Proposal searchProposalId(String propoId, User user) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Proposal> cq = cb.createQuery(Proposal.class);
 
        Root<Proposal> proposal = cq.from(Proposal.class);
        
	    Predicate proposalPredicate = cb.equal(proposal.get("pId"), propoId);
	    Predicate accPredicate = cb.equal(proposal.get("user"), user);
	    cq.where(cb.and(proposalPredicate, accPredicate)).distinct(true);
        
        TypedQuery<Proposal> query = em.createQuery(cq);
        Proposal propo=new Proposal();
        		
        try {
    		propo=query.getSingleResult();
    		System.out.println("Repo 2 ");
    	}catch(NoResultException e) {
    		propo=null;
    		System.out.println("Repo 3 ");
    	}catch (Exception ex) {
    		System.out.println("Repo 4 ");
    		propo=null;
		}
		return propo;
	}

	@Override
	public Proposal searchProId(String propoId) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Proposal> cq = cb.createQuery(Proposal.class);
 
        Root<Proposal> proposal = cq.from(Proposal.class);
        
	    Predicate proposalPredicate = cb.equal(proposal.get("pId"), propoId);
	    cq.where(proposalPredicate).distinct(true);
        
        TypedQuery<Proposal> query = em.createQuery(cq);
        
		return query.getSingleResult();
	}
}

package com.travelinsurance.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.travelinsurance.dto.Proposal;
import com.travelinsurance.dto.Test;
import com.travelinsurance.dto.Tests;
import com.travelinsurance.dto.User;

@Repository
public class ProposalRepositoryImpl implements ProposalRepositoryCustom{
	
	@Autowired
	EntityManager em;
/*
	@Override
	public List<Proposal> searchList() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Proposal> cq = cb.createQuery(Proposal.class);
 
        Root<Proposal> proposal = cq.from(Proposal.class);
        Fetch<Proposal, User> userProposal=proposal.fetch("user", JoinType.INNER);
        Predicate teacherPredicate = cb.equal(proposal.get("pId"), 1);
        cq.where(teacherPredicate).distinct(true);
 
        TypedQuery<Proposal> query = em.createQuery(cq);
        List<Proposal> list=query.getResultList();
		return list;
	}

	@Override
	public List<Tests> searchLists() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Tests> cq = cb.createQuery(Tests.class);
 
        Root<Tests> proposal = cq.from(Tests.class);
        Fetch<Tests, Test> userProposal=proposal.fetch("test", JoinType.INNER);
        Predicate teacherPredicate = cb.equal(proposal.get("test"), 2);
        cq.where(teacherPredicate).distinct(true);
 
        TypedQuery<Tests> query = em.createQuery(cq);
        List<Tests> list=query.getResultList();
		return list;
	}
	
*/

	@Override
	public Proposal searchProposalId(String propoId) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Proposal> cq = cb.createQuery(Proposal.class);
 
        Root<Proposal> proposal = cq.from(Proposal.class);
        
	    Predicate proposalPredicate = cb.equal(proposal.get("pId"), propoId);
	    cq.where(proposalPredicate).distinct(true);
        
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

}

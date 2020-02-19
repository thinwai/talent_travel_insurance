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

import com.travelinsurance.dto.Beneficial;
import com.travelinsurance.dto.ClaimType;
import com.travelinsurance.dto.Plan;
import com.travelinsurance.dto.Proposal;

@Repository
public class ClaimTypeRepositoryImpl implements ClaimTypeRepositoryCustom{

	@Autowired
	EntityManager em;
	
	@Override
	public List<ClaimType> findByPlanId(int planId) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ClaimType> cq = cb.createQuery(ClaimType.class);
 
        Root<ClaimType> cType = cq.from(ClaimType.class);
        Fetch<ClaimType, Plan> cTypePlan=cType.fetch("claimTypePlan", JoinType.INNER);
        Predicate claimTypePreidcate = cb.equal(((Path<ClaimType>) cTypePlan).get("planId"), planId);
        cq.where(claimTypePreidcate).distinct(true);
 
        TypedQuery<ClaimType> query = em.createQuery(cq);
        List<ClaimType> list=query.getResultList();
		return list;
	}

	@Override
	public Proposal findToClaim(String propoId) {
		try {
			System.out.println("Repo 1");
			CriteriaBuilder cb = em.getCriteriaBuilder();
	        CriteriaQuery<Proposal> cq = cb.createQuery(Proposal.class);
	        System.out.println("Repo 2");
	        Root<Proposal> proposal = cq.from(Proposal.class);
	        Fetch<Proposal, Beneficial> beneficialPerson=proposal.fetch("beneficial", JoinType.INNER);
	        Predicate claimPreidcate = cb.equal( proposal.get("pId"), propoId);
	        cq.where(claimPreidcate).distinct(true);
	        System.out.println("Repo 3");
	        TypedQuery<Proposal> query = em.createQuery(cq);
	        Proposal propo=query.getSingleResult();System.out.println("Repo 4");
			return propo;
		}catch (Exception e) {System.out.println("Repo 5");
			CriteriaBuilder cb = em.getCriteriaBuilder();
	        CriteriaQuery<Proposal> cq = cb.createQuery(Proposal.class);
	 
	        Root<Proposal> proposal = cq.from(Proposal.class);System.out.println("Repo 6");
	        Predicate claimPreidcate = cb.equal( proposal.get("pId"), propoId);
	        cq.where(claimPreidcate).distinct(true);
	 
	        TypedQuery<Proposal> query = em.createQuery(cq);
	        Proposal propo=query.getSingleResult();System.out.println("Repo 7");
			return propo;
		}
	}
}

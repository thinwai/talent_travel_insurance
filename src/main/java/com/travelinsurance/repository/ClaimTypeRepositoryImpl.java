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
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Proposal> cq = cb.createQuery(Proposal.class);
 
        Root<Proposal> proposal = cq.from(Proposal.class);
        Fetch<Proposal, Beneficial> beneficialPerson=proposal.fetch("beneficial", JoinType.INNER);
        Predicate claimPreidcate = cb.equal( proposal.get("pId"), propoId);
        cq.where(claimPreidcate).distinct(true);
 
        TypedQuery<Proposal> query = em.createQuery(cq);
        Proposal propo=query.getSingleResult();
		return propo;
	}
}

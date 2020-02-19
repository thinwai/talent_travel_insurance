package com.travelinsurance.repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.travelinsurance.dto.User;

@Repository
public class BeneficialRepositoryImpl implements BeneficialRepositoryCustom{
	
	@Autowired
	EntityManager em;

	@Override
	public String findLargestProposalId(User user) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT MAX(pId) FROM Proposal ");
		TypedQuery<String> q = em.createQuery(sb.toString(), String.class);
		String id = q.getSingleResult();
		System.out.println("PASs ________________________________________>>>>");
		return id;
	}
	
	/*
	 	em.createQuery("select max(e.dateProcessed) from Event e where e.org = :myOrg")
	  	.setParameter("myOrg", myOrg)
	  	.getSingleResult();
	  
	  
	  select max(p_id) from talent_travel_insurance.proposal where user_u_id=1;
	  
	  
	  	CriteriaBuilder qb = em.getCriteriaBuilder();
		CriteriaQuery<Number> cq = qb.createQuery(Number.class);
		Root<Event> root = cq.from(Event.class);
		cq.select(qb.max(root.get("dateProcessed")));
		cq.where(qb.equal(Event.get("org"), qb.parameter(MyOrgType.class, "myOrg")));
		em.createQuery(cq).setParameter("myOrg", myOrg).getSingleResult();
	  
	  
	  
	  
	  
	 */

}

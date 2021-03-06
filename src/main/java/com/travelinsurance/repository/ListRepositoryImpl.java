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
import javax.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.travelinsurance.dto.Beneficial;
import com.travelinsurance.dto.Claim;
import com.travelinsurance.dto.ClaimType;
import com.travelinsurance.dto.Payment;
import com.travelinsurance.dto.Plan;
import com.travelinsurance.dto.Proposal;
import com.travelinsurance.dto.User;
import com.travelinsurance.dto.Vehicle;
import com.travelinsurance.view_model.SearchModel;

@Repository
public class ListRepositoryImpl implements ListRepositoryCustom {

	@Autowired
	EntityManager em;

	@Override
	public List<Proposal> viewList(User user, SearchModel search) {
		System.out.println("Repo______________1");
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Proposal> cq = cb.createQuery(Proposal.class);
 
        Root<Proposal> propo = cq.from(Proposal.class);
        Fetch<Proposal, Beneficial> beneficial=propo.fetch("beneficial", JoinType.LEFT);
        Fetch<Proposal, Payment> payment=propo.fetch("payment", JoinType.LEFT);
        Fetch<Payment, Claim> claim=payment.fetch("claim", JoinType.LEFT);
    	
        int searchNo=search.getSearchNo();
        
        if(searchNo==0 || searchNo==1) {
        	Predicate propoIdPreidcate = cb.equal(propo.get("user"), user);
        	Predicate deleteStatus = cb.equal(propo.get("status"), 1);
        	cq.where(cb.and(propoIdPreidcate, deleteStatus)).distinct(true);
        	System.out.println("Repo______________1");
        }else if(searchNo==2) {
        	Predicate propoUserIdPreidcate = cb.equal(propo.get("user"), user);
        	Predicate deleteStatus = cb.equal(propo.get("status"), 1);
        	Predicate propoIdPreidcate = cb.equal(propo.get("pId"), search.getSearchData());
        	cq.where(cb.and(propoUserIdPreidcate, deleteStatus, propoIdPreidcate)).distinct(true);
        	System.out.println("Repo______________2");
        }else if(searchNo==3) {
        	Predicate propoUserIdPreidcate = cb.equal(propo.get("user"), user);
        	Predicate deleteStatus = cb.equal(propo.get("status"), 1);
        	Predicate propoIdPreidcate = cb.like(propo.get("holderName"), search.getSearchData()+"%");
        	cq.where(cb.and(propoUserIdPreidcate, deleteStatus, propoIdPreidcate)).distinct(true);
        	System.out.println("Repo______________3");
        }else if(searchNo==4) {
        	Predicate propoUserIdPreidcate = cb.equal(propo.get("user"), user);
        	Predicate deleteStatus = cb.equal(propo.get("status"), 1);
        	Predicate propoIdPreidcate = cb.like(((Path<Object>) beneficial).get("beneficialName"), search.getSearchData()+"%");
        	cq.where(cb.and(propoUserIdPreidcate, deleteStatus, propoIdPreidcate)).distinct(true);
        	System.out.println("Repo______________4");
        }
        
        cq.orderBy(cb.desc(propo.get("pId")));
       
        TypedQuery<Proposal> query = em.createQuery(cq);
        List<Proposal> list=query.getResultList();
		return list;
	}

	@Override
	public Proposal searchAllDetail(String propoId) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Proposal> cq = cb.createQuery(Proposal.class);
 
        Root<Proposal> propo = cq.from(Proposal.class);
        Fetch<Proposal, Beneficial> beneficial=propo.fetch("beneficial", JoinType.LEFT);
        Fetch<Proposal, Plan> plan=propo.fetch("plan", JoinType.INNER);
        Fetch<Proposal, Vehicle> vehicle=propo.fetch("vehicle", JoinType.INNER);
        Fetch<Proposal, Payment> payment=propo.fetch("payment", JoinType.LEFT);
        Fetch<Payment, Claim> claim=payment.fetch("claim", JoinType.LEFT);
        try {
        	Fetch<Claim, ClaimType> claimType=payment.fetch("claimType", JoinType.INNER);
        }catch (Exception e) {
		}
    	Predicate propoIdPreidcate = cb.equal(propo.get("pId"), propoId);
    	Predicate deleteStatus = cb.equal(propo.get("status"), 1);
    	cq.where(cb.and(propoIdPreidcate, deleteStatus)).distinct(true);
       
        TypedQuery<Proposal> query = em.createQuery(cq);
        
		return query.getSingleResult();
	}

}

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
import com.travelinsurance.dto.Payment;
import com.travelinsurance.dto.Proposal;
import com.travelinsurance.dto.User;
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

        //Predicate propoIdPreidcate = cb.equal(propo.get("user"), user);
    	//cq.where(propoIdPreidcate).distinct(true);
    	
        if(search.getSearchNo()==0 || search.getSearchNo()==1) {
        	Predicate propoIdPreidcate = cb.equal(propo.get("user"), user);
        	cq.where(propoIdPreidcate).distinct(true);
        	System.out.println("Repo______________1");
        }else if(search.getSearchNo()==2) {
        	Predicate propoUserIdPreidcate = cb.equal(propo.get("user"), user);
        	Predicate propoIdPreidcate = cb.equal(propo.get("pId"), search.getSearchData());
        	cq.where(cb.and(propoUserIdPreidcate, propoIdPreidcate)).distinct(true);
        	System.out.println("Repo______________10");
        }
       
        TypedQuery<Proposal> query = em.createQuery(cq);
        List<Proposal> list=query.getResultList();
		return list;
	}

}

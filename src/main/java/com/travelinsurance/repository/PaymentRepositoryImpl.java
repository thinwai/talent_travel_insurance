package com.travelinsurance.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.travelinsurance.dto.Payment;
import com.travelinsurance.dto.Proposal;

@Repository
public class PaymentRepositoryImpl implements PaymentRepositoryCustom{

	@Autowired
	EntityManager em;

	@Override
	public Payment searchPayment(String propoId, boolean status) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Payment> cq = cb.createQuery(Payment.class);
 
        Root<Payment> payment = cq.from(Payment.class);
        
        Proposal pro=new Proposal();
        pro.setpId(propoId);
        
        if(!status) {
	        Predicate payPredicate = cb.equal(payment.get("proposalPayment"), pro);
	        cq.where(payPredicate).distinct(true);
	        System.out.println("Pay Status Check 1 ");
        }else {
        	Predicate payPredicate = cb.equal(payment.get("proposalPayment"), pro);
        	Predicate payStatusPredicate = cb.equal(payment.get("payStatus"), 3);
        	cq.where(cb.and(payPredicate, payStatusPredicate)).distinct(true);
        	System.out.println("Pay Status Check 2 ");
        }
 
        TypedQuery<Payment> query = em.createQuery(cq);
        Payment pay=new Payment();
        		
        try {
        	pay=query.getSingleResult();
    		System.out.println("Repo 2 ");
    	}catch(NoResultException e) {
    		pay=null;
    		System.out.println("Repo 3 ");
    	}catch (Exception ex) {
    		System.out.println("Repo 4 ");
    		pay=null;
		}
		return pay;
	}
	
	
}

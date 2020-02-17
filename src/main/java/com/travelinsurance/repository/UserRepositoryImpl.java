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

import com.travelinsurance.dto.User;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom{

	@Autowired
	EntityManager em;
	
	@Override
	public User findByEmail(User user) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
 
        Root<User> ur = cq.from(User.class);
        
    	Predicate userNamePredicate = cb.equal(ur.get("email"), user.getEmail());
    	//Predicate userStatusPredicate = cb.equal(ur.get("userAccStatus"), 1);
    	
    	cq.where(userNamePredicate).distinct(true);
    	//cq.where(cb.and(userNamePredicate, userStatusPredicate)).distinct(true);
        
        TypedQuery<User> query = em.createQuery(cq);
        System.out.println("Repo 1 "+user.getEmail());
        User usr=new User();
    	try {
    		usr=query.getSingleResult();
    		 System.out.println("Repo 2 ");
    		 System.out.println("Repo 2 "+usr.getEmail());
    	}catch(NoResultException e) {
    		usr=null;
    		System.out.println("Repo 3 ");
    		 System.out.println("Repo 3 "+usr.getEmail());
    	}catch (Exception ex) {
    		System.out.println("Repo 4 ");
    		usr=null;
		}
		return usr;
	}

}

package com.jdc.weekend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jdc.weekend.entity.State;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class CriteriaStateService {
	
	@PersistenceContext
	private EntityManager em;

	public List<State> criteriaLocationService(String region){
		
		var criteriaBuilder = em.getCriteriaBuilder();
		var criteriaQuery = criteriaBuilder.createQuery(State.class);
		
		var root = criteriaQuery.from(State.class);
		criteriaQuery.select(root);
		
		var predicate = criteriaBuilder.equal(root.get("region"), region);
		criteriaQuery.where(predicate);
		
		return em.createQuery(criteriaQuery).getResultList();
	}
	
	
	
}

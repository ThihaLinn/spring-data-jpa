package com.jdc.weekend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.jdc.weekend.dto.StateDto;
import com.jdc.weekend.entity.District_;
import com.jdc.weekend.entity.State;
import com.jdc.weekend.entity.State_;
import com.jdc.weekend.repo.StateRepo;

import jakarta.persistence.criteria.JoinType;

@Service
public class CriteriaSpecService {
	
	@Autowired
	private StateRepo repo;

	public List<State> findByRegion(String region){
			return repo.findAll(byRegion("Central"));	
	}
	
	public long count(String region) {
		return repo.count(byRegion("Central"));	
		
	}
	
	public List<StateDto> findDtoByRegion(String region){
		return repo.findBy(byRegion(region) ,query -> query
				.project("id","name","region")
				.as(StateDto.class).all());
		
	}
	
	public long deleteByRegion(String region){
		return repo.delete(byRegion(region));
	}
	
	public List<State> findByDistrictNameLike(String name){
		
		Specification<State> spec =(root, query, cb) -> {
			
			var join = root.join(State_.district,JoinType.INNER);
			
			return cb.like(cb.lower(join.get(District_.name)), name.toLowerCase().concat("%"));
		};
		
		return repo.findAll(spec);
	}
	
	private Specification<State> byRegion (String region){
		return (root, query, cb) -> cb.equal(root.get("region"), region);
	}
	

	
}

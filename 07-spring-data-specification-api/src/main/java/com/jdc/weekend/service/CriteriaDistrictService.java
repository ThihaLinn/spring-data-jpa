package com.jdc.weekend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jdc.weekend.entity.District;
import com.jdc.weekend.entity.District_;
import com.jdc.weekend.entity.State_;
import com.jdc.weekend.repo.DistrictRepo;

@Service
public class CriteriaDistrictService {

	@Autowired
	private DistrictRepo repo;
	
	public List<District> findByNameLike(String name){
		
		Specification<District> spec = (root, query, cb) -> {
			var namelike = cb.like(cb.lower(root.get(District_.name)), name.toLowerCase().concat("%"));
			return namelike; 
		};
		
		return repo.findAll(spec);
	}
	
	public List<District > search(String region ,Integer stateId,String name){
		
		List<Specification<District>> list = new ArrayList<>();
		
		if(StringUtils.hasLength(region)) {
			list.add((root, query, cb) -> cb.like(root.get(District_.state).get(State_.region), region));
		}
		
		if (stateId != null && stateId >0) {
			list.add((root, query, cb) -> cb.equal(root.get(District_.state).get(State_.id), stateId));
		}
		
		if (StringUtils.hasLength(name)) {
			list.add((root, query, cb) -> cb.like(cb.lower(root.get(District_.name)), name.toLowerCase().concat("%")));
		}
		
		return repo.findAll(Specification.allOf(list));
	}
	
	
}

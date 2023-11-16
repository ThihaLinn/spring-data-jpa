package com.jdc.weekend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.jdc.weekend.entity.District;
import com.jdc.weekend.entity.District_;
import com.jdc.weekend.entity.State_;
import com.jdc.weekend.repo.DistrictRepo;

@Service
public class LocationService {
	
	@Autowired
	private DistrictRepo repo;

	public List<District> findByStateRegion(String region){
		
		Specification<District> list = (root, query, cb) -> {
			query.orderBy(cb.desc(root.get(District_.name)));
			 return cb.equal(cb.lower(root.get(District_.state).get(State_.region)), region.toLowerCase());
		};
		
		return repo.findAll(list);
	}
	
}
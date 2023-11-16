package com.jdc.weekend.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jdc.weekend.entity.District;
import com.jdc.weekend.entity.State;
import com.jdc.weekend.entity.dto.DistrictDto;
import com.jdc.weekend.repo.DistrictRepo;
import com.jdc.weekend.repo.StateRepo;

@Service
public class LocationService {
	
	@Autowired
	private StateRepo repo;
	
	@Autowired
	private DistrictRepo districtRepo;

	public Stream<State>  findByRegiionAsStream(String region){
		
		var state = new State();
		state.setRegion(region);
		
		var result = Example.of(state,
				ExampleMatcher.matching()
				.withIgnoreCase()
				);
		
		return repo.findBy(result,a-> a.stream());
				
	}
	
	public Optional<State>  findFirstByRegion(String region){
			
			var state = new State();
			state.setRegion(region);
			
			var result = Example.of(state,
					ExampleMatcher.matching()
					.withIgnoreCase()
					);
			
			return repo.findBy(result,a -> a.sortBy(Sort.by("name")).first());
					
		}
	
	
	public List<DistrictDto> findByStateId(int StateId){
		var state = new State();
		var district = new District();
		state.setId(StateId);
		district.setState(state);
		
		var result = Example.of(district,
				ExampleMatcher.matching().withIgnoreNullValues()
				);
		return districtRepo.findBy(result, a -> a.as(DistrictDto.class).all());
		
		
	}
	

	
}

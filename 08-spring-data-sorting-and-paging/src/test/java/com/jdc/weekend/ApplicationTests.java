package com.jdc.weekend;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.jdc.weekend.repo.DistrictRepo;
import com.jdc.weekend.service.LocationService;

@SpringBootTest
class ApplicationTests {
	
	@Autowired
	private DistrictRepo repo;
	
	@Autowired
	private LocationService service;

	@Test
	@Disabled
	void findByRegionWithNamingRuleJpa() {
		var districts = repo.findByStateRegion("South",Sort.by("name").ascending());
		for(var district :districts) {
			System.out.println(district.getName());
		}
	}
	@Test
	void findByRegionWithJpqlQuery() {
		var pageParam = PageRequest.of(1, 2, Sort.by("name"));
		
		var districts = repo.findByRegion("South",pageParam);
		
		System.out.println(districts.getTotalPages());
		System.out.println(districts.getNumberOfElements());
		System.out.println(districts.getNumber());		
		for(var district :districts) {
			System.out.println(district.getName());
		}
	}
	

	@Test
	@Disabled
	void findByRegionWithSpecificationApi() {
		var list = service.findByStateRegion("central");
		for (var district : list) {
			System.out.println(district.getName());
		}
		
		
	}
}

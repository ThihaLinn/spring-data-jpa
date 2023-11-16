package com.jdc.weekend;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.weekend.service.CriteriaDistrictService;
import com.jdc.weekend.service.CriteriaSpecService;

@SpringBootTest
public class joinTest {
	
	@Autowired
	public CriteriaSpecService service;
	
	@Autowired
	public CriteriaDistrictService distService;

	@Test
	@Disabled
	void join_test() {
		var list = service.findByDistrictNameLike("w");
		System.out.println(list);
	}
	
	@Test
	void district_test() {
		var list = distService.findByNameLike("m");
		for( var district :list ) {
			System.out.println(district.getName());
		}
	}
	
	@Test
	void dynamic_search() {
		var list = distService.search("South", 1, "p");
		for( var district :list ) {
			System.out.println(district.getName());
		}
		
	}
	
	
	
}

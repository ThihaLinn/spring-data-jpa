package com.jdc.weekend;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.weekend.service.CriteriaSpecService;
import com.jdc.weekend.service.CriteriaStateService;

@SpringBootTest
class SpringDataSpecificationApiApplicationTests {
	
	@Autowired
	private CriteriaStateService criService;
	
	@Autowired
	private CriteriaSpecService specService;

	@Test
	@Disabled
	void criteria_test() {
		
		var list = criService.criteriaLocationService("Central");
		for(var name : list) {
			System.out.println(name.getName());
		}
		
	}
	
	@Test
	@Disabled
	void spec_criteria_test() {
		
		var list =specService.findByRegion("East");
		for(var name : list) {
			System.out.println(name.getName());
			
		}
		System.out.println(list);
	}
	
	@Test
	@Disabled
	void cout_criteria_test() {
		
		var value = specService.count("Central");
		System.out.println(value);
	}
	
	@Test
	@Disabled
	void find_dto_by_region() {
		
		var list = specService.findDtoByRegion("South");
		
		for(var state :list ) {
			System.out.printf("%d : %s %s%n".formatted(state.getId(),state.getName(),state.getCapital()));
		}
		
		System.out.println(list);
	}

	@Test
	void delete_by_region() {
		var list =specService.deleteByRegion("East");
		System.out.println(list);
		
	}
}

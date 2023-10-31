package com.jdc.weekend.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.weekend.config.JpaCongfiguration;
import com.jdc.weekend.entity.State.Type;
import com.jdc.weekend.repo.StateRepo;

@SpringJUnitConfig(classes = JpaCongfiguration.class)
public class Aggregation {
	
	@Autowired
	private StateRepo repo;

	@Test 
	void test() {
		var result = repo.stateList(Type.Region);
		
		for(var dto : result) {
			dto.show();
		}
	}
	
}

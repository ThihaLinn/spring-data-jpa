package com.jdc.weekend.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.weekend.config.JpaCongfiguration;
import com.jdc.weekend.dtoInf.StateValue;
import com.jdc.weekend.repo.StateRepo;

@SpringJUnitConfig(classes = JpaCongfiguration.class)
public class DynamicProjection {
	
	@Autowired
	private StateRepo repo;

	@Test
	void test() {
		var result = repo.findById(1,StateValue.class); 
		System.out.println(result.getDisplayName());
	}
	
}

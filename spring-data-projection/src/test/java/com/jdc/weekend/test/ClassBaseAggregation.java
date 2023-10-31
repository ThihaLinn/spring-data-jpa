package com.jdc.weekend.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.weekend.config.JpaCongfiguration;
import com.jdc.weekend.repo.StateAggregateRepo;

@SpringJUnitConfig(classes = JpaCongfiguration.class)
public class ClassBaseAggregation {
	
	@Autowired
	private StateAggregateRepo repo;

	@Test()
	void test() {
		var result = repo.findOneById(1);
		
		System.out.println(result);
	}
	
}

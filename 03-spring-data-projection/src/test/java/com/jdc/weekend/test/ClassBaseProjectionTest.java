package com.jdc.weekend.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.weekend.config.JpaCongfiguration;
import com.jdc.weekend.repo.StateRecordRepo;

@SpringJUnitConfig(classes = JpaCongfiguration.class)
public class ClassBaseProjectionTest {
	
	@Autowired
	private StateRecordRepo repo;

	@Test
	void test() {
		var result =repo.findOneById(1);
		assertNotNull(result);
		
		System.out.println(result.getDisplayName());
	}
	
}

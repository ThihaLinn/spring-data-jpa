package com.jdc.weekend.test;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.weekend.config.JpaCongfiguration;
import com.jdc.weekend.repo.StateRepo;

@SpringJUnitConfig(classes = JpaCongfiguration.class)
public class NullableParamTest {
	
	@Autowired
	private StateRepo repo;

	@Test
	void test() {
		var result = repo.findOneByName(null);
		System.out.println(result);
//		assertNull(result);
	}
	
}

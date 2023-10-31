package com.jdc.weekend.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.weekend.config.JpaCongfiguration;
import com.jdc.weekend.entity.State.Type;
import com.jdc.weekend.repo.StateNativeRepo;
import com.jdc.weekend.repo.StateRepo;

@SpringJUnitConfig(classes = JpaCongfiguration.class)
@TestMethodOrder(OrderAnnotation.class)
public class StateNativeQueryTest {
	
	@Autowired
	private StateNativeRepo repo;

	@Order(1)
	@ParameterizedTest
	@CsvSource(value = {
			"Region,7",
			"State,7",
			"Union,1"
	})
	void find_By_type(String type,int count) {
		var result = repo.findByNativeSql(type);
		assertThat(result, hasSize(count));
	}
	
}

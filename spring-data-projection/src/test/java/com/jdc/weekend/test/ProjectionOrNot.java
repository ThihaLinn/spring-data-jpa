package com.jdc.weekend.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.weekend.config.JpaCongfiguration;
import com.jdc.weekend.repo.DistrictInfRepo;

@SpringJUnitConfig(classes = JpaCongfiguration.class)
public class ProjectionOrNot {
	
	@Autowired
	private DistrictInfRepo  repo;

	@ParameterizedTest
	@CsvSource({
		"1,8",
		"15,4"
	})
	void find_by_state_id(int id,int size) {
		var result = repo.findByStateId(id);
		assertThat(result,hasSize(size));
	}
}

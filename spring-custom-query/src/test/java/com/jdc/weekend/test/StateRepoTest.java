package com.jdc.weekend.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.weekend.config.JpaCongfiguration;
import com.jdc.weekend.entity.State.Type;
import com.jdc.weekend.repo.StateRepo;

import jakarta.transaction.Transactional;

@SpringJUnitConfig(classes = JpaCongfiguration.class)
@TestMethodOrder(OrderAnnotation.class)
public class StateRepoTest {
	
	@Autowired
	StateRepo repo;

	@Order(1)
	@ParameterizedTest
	@CsvSource(value = {
			"Region,7",
			"State,7",
			"Union,1"
	})
	void find_By_type(Type type,int count) {
		var result = repo.findByType(type);
		assertThat(result, hasSize(count));
	}
	
	@Order(2)
	@ParameterizedTest
	@CsvSource(value = {
			"Region,7",
			"State,7",
			"Union,1"
	})
	@Transactional
	void stream_By_type(Type type,long count) {
		var result = repo.streamByType(type);
		assertThat(result.count(), is(count));

	}
	
	@Order(3)
	@ParameterizedTest
	@CsvSource(value = {
			"Central,4",
			"East,1",
			"West,1"
	})
	void count_by_region(String region,long count) {
		var result = repo.countByRegion(region);
		assertThat(result, is(count));
	}
	
	@Order(4)
	@ParameterizedTest
	@ValueSource(strings = {
			"Yangon",
			"Bago",
			"Mandalay"
	})
	void find_one_by_name(String name) {
		var result = repo.findOneByName(name);
		assertThat(result, notNullValue());
	}
	
	
	@Order(5)
	@ParameterizedTest
	@CsvSource(value = {
			"Region,3",
			"State,3",
			"Union,1"
	})
	void find_top3_by_type(Type type,int count) {
		System.err.println("find_top3_by_type");
		var result = repo.findTop3ByType(type);
		assertThat(result.size(), is(count));
	}
	
	@Order(6)
	@ParameterizedTest
	@CsvSource(value = {
			"Region,7",
			"State,7",
			"Union,1"
	})
	void find_distinct_by_type(Type type,int count) {
		System.err.println("find_distinct_by_type");
		var result = repo.findDistinctByType(type);
		assertThat(result.size(), is(count));
	}
	
	@Order(7)
	@ParameterizedTest
	@CsvSource(value = {
			"1",
			"2",
			"3"
	})
	void remove_by_id(int id) {
		 System.err.println("remove_by_id");
		 repo.removeById(id);
		 var result = repo.findById(id);
		 assertThat(result, nullValue());
	}
	
}

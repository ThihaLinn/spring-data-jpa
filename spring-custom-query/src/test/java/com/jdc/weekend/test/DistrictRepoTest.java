package com.jdc.weekend.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.weekend.config.JpaCongfiguration;
import com.jdc.weekend.repo.DistrictRepo;

@SpringJUnitConfig(classes = JpaCongfiguration.class)
@TestMethodOrder(OrderAnnotation.class)
public class DistrictRepoTest {
	
	@Autowired
	private DistrictRepo repo;

	@ParameterizedTest
	@CsvSource({
		"South,8"
	})
	void find_by_state_region(String name,int count) {
		
		var result = repo.findByStateRegion(name);
		assertThat(result, hasSize(count));		
	}
	
	@ParameterizedTest
	@CsvSource({
		"M,3"
	})
	void find_By_name_Starting_with_ignore_case(String name ,int count) {
		System.err.println("find_By_name_Starting_with_ignore_case");
		var result = repo.findByNameStartingWithIgnoringCaseOrderByName(name);
		assertThat(result, hasSize(count));
	}
	
	@ParameterizedTest
	@CsvSource({
		"1,p,2"
	})
	void find_By_id_and_name_Starting_with_ignore_case(int id,String name ,int count) {
		System.err.println("find_By_id_and_name_Starting_with_ignore_case");
		var result = repo.findByStateIdAndNameStartingWithIgnoringCase(id,name);
		assertThat(result, hasSize(count));
	}
	
	@ParameterizedTest
	@CsvSource({
		"1,p,2"
	})
	void find_By_name_query(int id,String name ,int count) {
		System.err.println("find_By_name_query");
		var result = repo.findByAnnotationQuery(id,name.concat("%"));
		assertThat(result, hasSize(count));
	}
}

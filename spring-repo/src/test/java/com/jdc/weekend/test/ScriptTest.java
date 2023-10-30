package com.jdc.weekend.test;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.weekend.config.JpaCongfiguration;
import com.jdc.weekend.entity.State;
import com.jdc.weekend.repo.StateRepo;

@SpringJUnitConfig(classes = JpaCongfiguration.class)
public class ScriptTest {

	@Autowired
	private StateRepo repo;

	@ParameterizedTest
	@Sql(scripts = "/save/init.sql")
	@CsvFileSource(resources = "/save/save_test.txt", delimiter = '\t')
	void save_test(String name, String type, String capital, String region) {

		// prepare input
		var input = new State(name, type, capital, region);
		// Execute Test method
		var result = repo.save(input);
		// Check Result

		assertThat(result, hasProperty("id", is(1)));

	}

	@ParameterizedTest
	@Sql(scripts = { 
			"/save/init.sql",
			"/load-data.sql"
	})
	@CsvSource({
		"1,Test Name,Test Type,Test Capital,Test Region"
	})
	void update_test(int id,String name, String type, String capital, String region) {
				
		var input = new State(id,name, type, capital, region);
		
		repo.save(input);
		
		var result = repo.findById(id).get();
		
		assertThat(result, allOf(
				notNullValue(),
				hasProperty("id",is(id)),
				hasProperty("name",is(name)),
				hasProperty("type",is(type)),
				hasProperty("capital",is(capital)),
				hasProperty("region",is(region))
				));
		
	}

}

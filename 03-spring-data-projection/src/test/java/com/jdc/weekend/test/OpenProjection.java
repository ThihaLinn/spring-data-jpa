package com.jdc.weekend.test;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.weekend.config.JpaCongfiguration;
import com.jdc.weekend.entity.State.Type;
import com.jdc.weekend.repo.StateRepo;

@SpringJUnitConfig(classes = JpaCongfiguration.class)
public class OpenProjection {
	
	@Autowired
	private StateRepo repo;

	@Test
	void DisplayIdAndName() {
		var result = repo.findOneById(1);
		assertThat(result, allOf(
				hasProperty("id",is(1)),
				hasProperty("name",is(result.getName())),
				hasProperty("type",is(Type.Region)),
				hasProperty("displayName",is(result.getDisplayName()))
				));
	}
	
	@Test
	void SateValue() {
		var result = repo.findOneByName("Ayeyarwady");
		assertThat(result, allOf(
				hasProperty("id",is(result.getId())),
				hasProperty("name",is(result.getName())),
				hasProperty("displayName",is("Ayeyarwady Region"))
				
				));
	}
	
}

package com.jdc.weekend;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;

import com.jayway.jsonpath.internal.function.text.Length;
import com.jdc.weekend.entity.State;
import com.jdc.weekend.repo.StateRepo;

@SpringBootTest
class SpringDataQbeApplicationTests {
	
	@Autowired
	private StateRepo repo;

	@Test
	void find_by_name_and_region() {
		var probe = new State();
		probe.setRegion("Central");
		probe.setCapital("Magwe");
		
		var example = Example.of(probe,ExampleMatcher.matching().withIgnorePaths("id"));
		var list = repo.findAll( example);
		
		System.out.println(list);
		
		assertThat(list,hasSize(1));
	}

	@Test
	void find_by_name_start_with() {
		var probe = new State();
		probe.setName("k");
		
		var example = Example.of(probe,
				ExampleMatcher.matching()
				.withIgnoreNullValues()
				.withIgnoreCase()
				.withStringMatcher(StringMatcher.STARTING)
				); 
		
		var list = repo.findAll(example);
		System.out.println(list);
		assertThat(list , hasSize(3));
				
	}
	
	@Test
	void find_by_region_and_start_with_name() {
		var probe = new State();
		probe.setRegion("central");
		probe.setName("m");
		
		var example  = Example.of(probe, 
				ExampleMatcher.matching()
				.withMatcher("region", match -> match.ignoreCase().exact())
				.withMatcher("name", match -> match.ignoreCase().startsWith())
				);
		
		var list = repo.findAll(example);
		assertThat(list,hasSize(2));
	}
}

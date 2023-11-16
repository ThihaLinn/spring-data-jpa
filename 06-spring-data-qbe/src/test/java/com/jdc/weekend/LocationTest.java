package com.jdc.weekend;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.weekend.service.LocationService;

@SpringBootTest
public class LocationTest {
	
	@Autowired
	private LocationService service;

	@Test
	void find_by_region_as_stream() {
		var result = service.findByRegiionAsStream("east");
		assertNotNull(result);
		
	}
	
	@Test
	void find_first_by_region() {
		var result = service.findFirstByRegion("central");
		assertThat(result.get().getName(),is("Magway"));
		
	}
	
	@Test
	void findBySateId() {
		var result =service.findByStateId(15);
		assertThat(result,hasSize(4) );
	}
	
}

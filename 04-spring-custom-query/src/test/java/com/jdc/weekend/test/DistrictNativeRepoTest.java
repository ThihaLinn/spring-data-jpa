package com.jdc.weekend.test;

import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.weekend.config.JpaCongfiguration;
import com.jdc.weekend.repo.DistrictNativeRepo;

@SpringJUnitConfig(classes = JpaCongfiguration.class)
@TestMethodOrder(OrderAnnotation.class)
public class DistrictNativeRepoTest {

	@Autowired
	private DistrictNativeRepo repo;
	
	
	@ParameterizedTest
	@CsvSource({
		"1,8",
		"15,4"
	})
	void find_by_native_sql(int id,int size) {
		var result = repo.findByNativeSql(id);
		assertThat(result, hasSize(size));
		
		for(var district : result) {
			System.out.println(district.getState().getName());
		}
		
	}
	
}

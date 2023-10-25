package com.jdc.weekend.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.weekend.config.JpaConfiguration;
import com.jdc.weekend.entity.Course;
import com.jdc.weekend.repo.CourseRepo;

@SpringJUnitConfig(classes = JpaConfiguration.class)
public class CourseRepoJavaTest {
	
	@Autowired
	private CourseRepo repo;

	@ParameterizedTest
	@CsvSource({"1,Java Basic,4,50000"})
	void create_test(int id ,String name,int duration,int fees) {
		
		var input= new Course(name, duration, fees);
		
		var result  = repo.save(input);
		
		assertEquals(result.getId(), id);
		
		
		
	}
	
}

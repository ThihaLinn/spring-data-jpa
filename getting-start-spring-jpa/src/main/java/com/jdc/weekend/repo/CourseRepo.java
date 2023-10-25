package com.jdc.weekend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.weekend.entity.Course;

public interface CourseRepo extends JpaRepository<Course, Integer> {

	
	
}

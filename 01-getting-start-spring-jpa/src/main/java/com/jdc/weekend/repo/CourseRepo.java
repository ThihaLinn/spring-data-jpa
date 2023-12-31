package com.jdc.weekend.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.weekend.entity.Course;

public interface CourseRepo extends JpaRepository<Course, Integer> {

	List<Course> findByNameLikeIgnoringCase(String name);
	
}

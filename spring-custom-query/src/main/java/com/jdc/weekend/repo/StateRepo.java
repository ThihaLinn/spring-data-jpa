package com.jdc.weekend.repo;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.weekend.entity.State;
import com.jdc.weekend.entity.State.Type;

public interface StateRepo extends JpaRepository<State, Integer>{

	List<State> findByType(Type type);
	
	Stream<State> streamByType(Type type);
	
	State findOneByName(String name);
	
	long countByRegion(String region);
	
	List<State> findTop3ByType(Type type);
	
	List<State> findDistinctByType(Type type);
	
	List<State> findById(int id);
	
	@Transactional
	void removeById(int id);
	
}

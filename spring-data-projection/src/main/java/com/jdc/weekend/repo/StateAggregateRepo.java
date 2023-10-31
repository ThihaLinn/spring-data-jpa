package com.jdc.weekend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jdc.weekend.entity.State;
import com.jdc.weekend.record.StateWithDistrictCount;

public interface StateAggregateRepo extends JpaRepository<State, Integer> {

	@Query("""
			select new com.jdc.weekend.record.StateWithDistrictCount(s.id id,s.name name,size(s.district) districtCount)
			from State s where s.id = ?1
			""")
	StateWithDistrictCount findOneById(int id);
	
}

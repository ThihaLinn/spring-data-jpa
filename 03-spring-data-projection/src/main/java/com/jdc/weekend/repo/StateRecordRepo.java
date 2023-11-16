package com.jdc.weekend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.weekend.entity.State;
import com.jdc.weekend.record.StateRecord;

public interface StateRecordRepo extends JpaRepository<State, Integer>{
	
	
	StateRecord findOneById(int id);
	
}

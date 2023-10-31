package com.jdc.weekend.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jdc.weekend.dtoInf.DisplayIdAndName;
import com.jdc.weekend.dtoInf.StateValue;
import com.jdc.weekend.dtoInf.StateWithDistrictCount;
import com.jdc.weekend.entity.State;
import com.jdc.weekend.entity.State.Type;
import com.jdc.weekend.record.StateRecord;

public interface StateRepo extends JpaRepository<State, Integer> {

	@Query("""
			select s.id id,s.name name,size(s.district) districtCount from State s 
			where s.type=?1
			""")
	List<StateWithDistrictCount> stateList(Type type);
	
	DisplayIdAndName findOneById(int id);
	
	StateValue findOneByName(String name);
	
	<T> T findById(int id,Class<T> type);

	
}

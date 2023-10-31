package com.jdc.weekend.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jdc.weekend.entity.District;
public interface DistrictNativeRepo extends JpaRepository<District, Integer>{

	@Query(nativeQuery = true,
			value = "select * from district where state_id = ?")
	List<District> findByNativeSql(int id);
	
}

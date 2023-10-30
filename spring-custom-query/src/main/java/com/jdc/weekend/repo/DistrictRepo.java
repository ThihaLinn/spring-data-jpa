package com.jdc.weekend.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jdc.weekend.entity.District;

public interface DistrictRepo extends JpaRepository<District, Integer>{

	List<District> findByStateRegion(String name);
	
	List<District> findByNameStartingWithIgnoringCaseOrderByName(String name);
	
	List<District> findByStateIdAndNameStartingWithIgnoringCase(int id,String name);
	
	List<District> findByNameQuery(@Param("id") int id,@Param("name") String name);
	
	@Query("select d from District d where d.state.id =:id and lower(d.name) like lower(:name)")
	List<District> findByAnnotationQuery(@Param("id") int id,@Param("name") String name);
	
}

package com.jdc.weekend.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.weekend.entity.District;

public interface DistrictRepo extends JpaRepository<District, Integer>{

	List<District> findByStateRegion(String name);
	
	List<District> findByNameStartingWithIgnoringCaseOrderByName(String name);
	
	List<District> findByStateIdAndNameStartingWithIgnoringCase(int id,String name);
	
	List<District> findByStateAndName(int id,String name);
	
}

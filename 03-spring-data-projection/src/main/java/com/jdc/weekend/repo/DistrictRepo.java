package com.jdc.weekend.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jdc.weekend.entity.District;

public interface DistrictRepo extends JpaRepository<District, Integer>{

	List<District> findByStateId(int id);
	
}

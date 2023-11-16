package com.jdc.weekend.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.weekend.dtoInf.DistrictInf;
import com.jdc.weekend.entity.District;

public interface DistrictInfRepo extends JpaRepository<District, Integer>{

	List<DistrictInf> findByStateId(int id);
	
}

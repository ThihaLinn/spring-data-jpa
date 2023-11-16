package com.jdc.weekend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.jdc.weekend.entity.District;

public interface DistrictRepo extends JpaRepository<District, Integer> ,JpaSpecificationExecutor<District>{

}

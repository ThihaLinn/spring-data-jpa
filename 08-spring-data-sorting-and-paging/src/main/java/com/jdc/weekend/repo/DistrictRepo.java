package com.jdc.weekend.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.weekend.entity.District;

public interface DistrictRepo extends JpaRepositoryImplementation<District, Integer>{

	List<District> findByStateRegion(String string,Sort sort);
	
	@Query(
			value ="select d from District d where d.state.region = ?1  ",
			countQuery = "select count(d) from District d where d.state.region = ?1 "
			)
	Page<District> findByRegion(String region,Pageable page);

}

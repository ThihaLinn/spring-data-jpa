package com.jdc.weekend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.jdc.weekend.entity.State;

public interface StateRepo extends JpaRepository<State,Integer>,JpaSpecificationExecutor<State>{

}

package com.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.springboot.entity.LevelEntity;
import com.springboot.entity.SchoolDataEntity;

public interface LevelDao extends JpaRepository<LevelEntity, Integer>  , JpaSpecificationExecutor<LevelEntity>{
	
 
}

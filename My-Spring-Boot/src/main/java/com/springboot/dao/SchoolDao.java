package com.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.springboot.entity.SchoolDataEntity;
@Repository
public interface SchoolDao extends JpaRepository<SchoolDataEntity, Integer> , JpaSpecificationExecutor<SchoolDataEntity>{

}

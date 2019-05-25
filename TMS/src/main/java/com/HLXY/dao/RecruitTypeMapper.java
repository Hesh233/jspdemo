package com.HLXY.dao;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.HLXY.entity.RecruitType;

@Mapper

public interface RecruitTypeMapper {
	int deleteByPrimaryKey(Integer id);
	List<RecruitType> selectAll(@Param("page")Integer page, @Param("limit")Integer limit); 
	int allCount();
	int insert(RecruitType record);
	int updateByPrimaryKeySelective(RecruitType record);
	RecruitType selectByPrimaryKey(Integer id);
}

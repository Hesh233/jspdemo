package com.HLXY.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.HLXY.entity.Recruit;
@Mapper
public interface RecruitMapper {


	int deleteByPrimaryKey(Integer id);

	int insert(Recruit record);

	int insertSelective(Recruit record);

	Recruit selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Recruit record);

	int updateByPrimaryKey(Recruit record);

	Integer selectRecruitCount(@Param("interviewType") Integer interviewType);

	List<Map<Object, Object>> selectStudentRecruit(@Param("interviewType")Integer interviewType, @Param("page")Integer page, @Param("limit")Integer limit);


}
package com.HLXY.dao;

import org.apache.ibatis.annotations.Mapper;

import com.HLXY.entity.TeaStu;
@Mapper
public interface TeaStuMapper {


	int deleteByPrimaryKey(Integer studentNum);

	TeaStu selectByPrimaryKey(Integer studentNum);

	int updateByPrimaryKeySelective(TeaStu record);

	int updateByPrimaryKey(TeaStu record);

	int insert(TeaStu record);

	int insertSelective(TeaStu record);


}
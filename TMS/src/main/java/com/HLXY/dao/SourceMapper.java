package com.HLXY.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.HLXY.entity.Source;
@Mapper
public interface SourceMapper {

	int deleteByPrimaryKey(Integer id);

	int insert(Source record);

	int insertSelective(Source record);

	Source selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Source record);

	int updateByPrimaryKey(Source record);

	List<Source> selcetByStudentNumAndApprove(Integer StudentNum,Integer Approve);

	List<Source> selcetByStudentNum(Integer StudentNum);
	
	List<Map<Object,Object>> teacherPage(@Param("teacherNum")int teacherNum,@Param("page")int page, @Param("limit")int limit, @Param("ascOrDesc")String ascOrDesc);

	Integer teacherPageCount(@Param("teacherNum")int teacherNum);

	void updateSource(Source sou);
}
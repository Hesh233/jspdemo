package com.HLXY.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.HLXY.entity.Notice;
@Mapper
public interface NoticeMapper {




	int deleteByPrimaryKey(Integer id);

	int insert(Notice record);

	int insertSelective(Notice record);

	Notice selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Notice record);

	int updateByPrimaryKey(Notice record);

	List<Map<Object, Object>> selectNotice(@Param("teacherCheck")Integer teacherCheck,@Param("studentNum")Integer studentNum,@Param("type")Integer type,  @Param("page")Integer page, @Param("limit")Integer limit);

	Integer selectNoticeCount(@Param("teacherCheck")Integer teacherCheck,@Param("studentNum")Integer studentNum,@Param("type")Integer type);
	
	Map<String, Object> selectOne(@Param("id")Integer id);
	
	List<Integer> checkSelectId(@Param("studentNum")Integer studentNum);
	
}
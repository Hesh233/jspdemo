package com.HLXY.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.HLXY.entity.Dirary;
@Mapper
public interface DiraryMapper {



	int deleteByPrimaryKey(Integer id);

    int insert(Dirary dir);

    int insertSelective(Dirary dir);

    Dirary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dirary dir);

    int updateByPrimaryKey(Dirary dir);
    
    //根据周数和学号查询信息
    Dirary selectByStuNumAndWeek(@Param("weekNum")Integer weekNum, @Param("studentNum")Integer studentNum);

	Integer selectAllCount(@Param("weekNum")Integer weekNum, @Param("teacherNum")Integer teacherNum);

	List<Map<Object,Object>> selectAllSort(@Param("teacherNum")int teacherNum,@Param("sortKey")String sortKey, @Param("page")int page, @Param("limit")int limit, @Param("ascOrDesc")String ascOrDesc,@Param("weekNum")Integer weekNum);

	Dirary oneWeekly(@Param("weekNum")Integer weekNum, @Param("studentNum")Integer studentNum);
	
	Integer teacherNum(@Param("studentNum")Integer studentNum);
	
	List<String> selectClass(@Param("teacherNum")Integer teacherNum);
}
package com.HLXY.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.HLXY.entity.Guide;
@Mapper
public interface GuideMapper {


	int deleteByPrimaryKey(Integer id);

    int insert(Guide record);

    int insertSelective(Guide record);

    Guide selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Guide record);

    int updateByPrimaryKey(Guide record);
    
    List<Guide> selectByTeacherNumAndWeekAndClass(@Param("teacherNum")Integer teacherNum,@Param("weekNum")Integer weekNum,@Param("studentClass")String studentClass);

    String selectClass(@Param("teacherNum")Integer teacherNum);
}
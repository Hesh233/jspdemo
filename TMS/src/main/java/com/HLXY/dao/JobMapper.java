package com.HLXY.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.HLXY.entity.Job;
@Mapper
public interface JobMapper {

	int deleteByPrimaryKey(Integer id);

    int insert(Job record);

    int insertSelective(Job record);

    Job selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Job record);

    int updateByPrimaryKey(Job record);
    
    public Job selectByLastestStudentNum(@Param("studentNum")Integer studentNum);
    
    public List<Job> selectJobListPage();

    public List<Map<Object,Object>> selectStuListAndSort(@Param("teaNum")Integer teaNum,@Param("sortKey")String sortKey,@Param("ascOrDesc")String ascOrDesc,@Param("page")Integer page, @Param("limit")Integer limit);

    public List<Integer> selectStuListAndSortCount(@Param("teaNum")Integer teaNum);
    /**
     * 根据学生号更新最新的记录
     * @param record
     * @return
     */
    int updateByLatestStuNumSelective(Job record);
}
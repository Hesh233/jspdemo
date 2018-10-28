package com.ssm.Dao;

import org.apache.ibatis.annotations.Param;

import com.ssm.domain.TypeInfo;

public interface TypeInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TypeInfo record);

    int insertSelective(TypeInfo record);

    TypeInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TypeInfo record);

    int updateByPrimaryKey(TypeInfo record);
    
    TypeInfo findTtile(@Param(value="id")int id) ;
    

}
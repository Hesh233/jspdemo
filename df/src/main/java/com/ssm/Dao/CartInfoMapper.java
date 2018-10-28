package com.ssm.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.domain.CartInfo;

public interface CartInfoMapper {
    int deleteByPrimaryKey(Integer id);



    int insertSelective(CartInfo record);

    CartInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CartInfo record);

    int updateByPrimaryKey(CartInfo record);
    
    int getnum(@Param(value="id")int id);
    
    List<CartInfo> getcount(@Param(value="id")int id);
    
    int editcount(@Param(value="id")int id,@Param(value="goodsid")int goodsid,@Param(value="num")int num);

    int delectcart(@Param(value="id")int id,@Param(value="goodsid")int goodsid);

	void addcart(@Param(value="id")int id, @Param(value="goodsid")int goodsid, @Param(value="num")int count);
	
	CartInfo searchhavecount(@Param(value="id")int id, @Param(value="goodsid")int goodsid);

	int insert(@Param(value="id")int id, @Param(value="goodsid")int goodsid, @Param(value="num")int count);
}
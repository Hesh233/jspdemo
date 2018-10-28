package com.ssm.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.domain.CartInfo;
import com.ssm.domain.GoodsInfo;

public interface GoodsInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsInfo record);

    int insertSelective(GoodsInfo record);

    GoodsInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsInfo record);

    int updateByPrimaryKeyWithBLOBs(GoodsInfo record);

    int updateByPrimaryKey(GoodsInfo record);
    
    public List<GoodsInfo> selectbygclick(@Param(value="gtype_id")int gtype_id);
    
    public List<GoodsInfo> selectbynewgoods(@Param(value="gtype_id")int gtype_id);
    
    public GoodsInfo viewdetail(@Param(value="id")int id);
    
    public List<GoodsInfo> viewnews ();
    
    public List<GoodsInfo> viewlist1(@Param(value="gtype_id")int gtype_id,@Param(value="type")String type,@Param(value="page")int page);
    
    public List<GoodsInfo> viewlist(@Param(value="gtype_id")int gtype_id,@Param(value="type")String type,@Param(value="page")int page,@Param(value="up")String up);

	public int selectcount(@Param(value="gtype_id")int gtype_id);
	
	public List<GoodsInfo> showsearch(@Param(value="key")String key,@Param(value="page")int page);
	
	public int showsearchcount(@Param(value="key")String key);
	
	public List<CartInfo> getcart(@Param(value="user_id")int id);
	
	public Integer SelectGclickbyGoodsid(@Param(value="id")int id);
	
	public void updateGclick(@Param(value="id")int id,@Param(value="gclick")int gclick);
} 
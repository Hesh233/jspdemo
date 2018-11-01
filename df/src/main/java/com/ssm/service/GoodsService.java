package com.ssm.service;

import java.util.List;
import java.util.Map;

import com.ssm.domain.GoodsInfo;

public interface GoodsService {
	public List showindex(int type_id);

	public GoodsInfo showdetails(int id);
	
	public List showlist(int gtype_id,int page,int type );
	
	public List shownew();

	public int typepage_count(int gtype_id);

	public String switchclass(int regex1);
	
	public List showsearch(String key,int page);
	
	public int showmaxsearch_page(String key);

	public void addgclick(int regex1);
	
	public GoodsInfo selectbypk(int id);

}

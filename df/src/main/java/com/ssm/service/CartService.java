package com.ssm.service;

import java.util.List;

import com.ssm.domain.CartInfo;

public interface CartService {
	public int getnum(int id);
	public List getcart(int id);
	public List getcount(int id);
	public int editcount(int id,int goodsid,int num);	
	public int delectcart(int id,int goodsid);
	public int addcart(int id, int goodsid, int count);
	public List getorder(int id);
}

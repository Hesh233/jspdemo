package com.ssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.Dao.CartInfoMapper;
import com.ssm.Dao.GoodsInfoMapper;
import com.ssm.domain.CartInfo;
import com.ssm.service.CartService;



@Service("cartService")
public class CartServiceImpl implements CartService{
	@Resource
	private CartInfoMapper cart;
	@Resource
	private GoodsInfoMapper goods;
	public int getnum(int id) {
		return cart.getnum(id);
	}
	public List getcart(int id) {
		List cartlist = goods.getcart(id);
		return cartlist;
	}
	public List getcount(int id) {

		return cart.getcount(id);
	}

	public int editcount(int id,int goodsid, int num) {
		//System.out.println(id);System.out.println(goodsid);System.out.println(num);
		cart.editcount(id, goodsid, num);
		return 0;
	}

	public int delectcart(int id, int goodsid) {
		cart.delectcart(id, goodsid);
		return 0;
	}

	public int addcart(int id, int goodsid, int count) {
		if(cart.searchhavecount(id, goodsid)!=null) {
			count = count+cart.searchhavecount(id, goodsid).getCount();
			cart.editcount(id,goodsid,count);
		return cart.searchhavecount(id, goodsid).getCount();
		}
		else {		
			cart.insert(id,goodsid,count);
		return cart.searchhavecount(id, goodsid).getCount();}
		
	}
	
}

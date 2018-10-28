package com.ssm.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.Dao.GoodsInfoMapper;
import com.ssm.Dao.TypeInfoMapper;
import com.ssm.domain.GoodsInfo;
import com.ssm.service.GoodsService;



@Service("goodsService")
public class GoodsServiceImpl implements GoodsService{
	@Resource
	private GoodsInfoMapper goods;
	@Resource
	private TypeInfoMapper type;
	public List showindex(int gtype_id)
	{
		List<GoodsInfo> listg = goods.selectbygclick(gtype_id);
		List<GoodsInfo> listn = goods.selectbynewgoods(gtype_id);
		List list = new ArrayList();
		list.add(listg);
		list.add(listn);
		return list;
	}
	public GoodsInfo showdetails(int id) {
		GoodsInfo g = goods.viewdetail(id);
		return g;
	}

	public List showlist(int gtype_id, int page, int typenum) {
		int count = goods.selectcount(gtype_id);
		int page_temp = page;
		int limit = 15;
		if (count < page * limit) {
			limit = count - (page - 1) * limit;
		}
		page = (page_temp - 1) * limit;
		String type = "";
		String up = "";
		if (typenum==1) {
			type = "id";
			up = "DESC";
		}
		else if(typenum==2) {
			type = "gprice";
			up = "ASC";
		}else {
			type = "gclick";
			up = "DESC";
		}
		//System.out.println(type);
		List<GoodsInfo> listg = goods.viewlist(gtype_id, type , page,up);
//		for(int i = 0 ; i < listg.size() ; i++) {
//			  System.out.println(listg.get(i).getId());
//			}
		return listg;
	}
	public int typepage_count(int gtype_id) {
		int count = goods.selectcount(gtype_id);
		if (count%15!=0) {
		count = count/15+1;}
		else {
			count = count/15;
		}
		return count;
	}
	public List shownew() {
		List n = goods.viewnews();
		return n;
	}
	public String switchclass(int regex1) {
		String ret = "";//实际存到数组上更好
		//System.out.println(type.findTtile(1).getTtitle());
		switch(regex1){
		case 1:
			ret = type.findTtile(1).getTtitle();
		   break;
		case 2:
			ret = type.findTtile(2).getTtitle();
		   break;
		case 3:
			ret = type.findTtile(3).getTtitle();
		   break;
		case 4:
			ret = type.findTtile(4).getTtitle();
	       break;
		case 5:
			ret = type.findTtile(5).getTtitle();
	       break;
		case 6:
			ret = type.findTtile(6).getTtitle();
	       break;		
	}
		return ret;
	}
	public List showsearch(String key,int page) {
		int count = 0;
		count = goods.showsearchcount(key);
		int page_temp = page;
		int limit = 15;
		if (count < page * limit) {
			limit = count - (page - 1) * limit;
		}
		page = (page_temp - 1) * limit;
		//System.out.println(page);
		List listg = goods.showsearch(key,page);
		return listg;
	}
	public int showmaxsearch_page(String key) {		
		int count = 0;
		try {
			 count = goods.showsearchcount(key);}
			catch(Exception e){
				return 0;
			}
		if (count%15!=0) {
		count = count/15+1;}
		else {
			count = count/15;
		}
		return count;
	}

	public void addgclick(int regex1) {
		int gclick = goods.SelectGclickbyGoodsid(regex1);
		gclick ++;
		goods.updateGclick(regex1, gclick);		
	}
}

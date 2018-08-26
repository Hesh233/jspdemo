package com.ssm.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.dao.MenuDao;
import com.ssm.domain.Menu;
import com.ssm.service.MenuService;
@Service("menuService")
public class MenuServiceImpl implements MenuService {
	  @Resource
	private MenuDao menuDao;
	
	public int getcount() {
		int count = menuDao.selectcount();
		return count;
	}

	public List<List<Menu>> selectAll(int page, int limit) {
		// 分页功能		
		int count = menuDao.selectcount(); // 查找数据条数
		int page_temp = page;
		int limit_temp = limit;
		System.out.println("数据条数"+count);
		if (count < page * limit) {
			limit = count - (page - 1) * limit;
		}
		page = (page_temp - 1) * limit_temp;
		List<List<Menu>> menu = menuDao.selectAll(page, limit);// 查找所有数据
		return menu;
	}
	public void selectDel(String[] delmenu)
	{
		menuDao.delmenuByids(delmenu);
	}
	public void change(int id,int menubarid,String name,double price,String status,String iid,String menubariid)
	{	
		menuDao.updateById(id, menubarid, name, price, status, Integer.valueOf(iid),Integer.valueOf(menubariid));
	}

	public void insert(Integer id, Integer menubarid, String name, double price, String status) {
		menuDao.insert(id, menubarid, name, price, status);
		
	}
}

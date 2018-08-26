package com.ssm.service;

import java.util.List;

import com.ssm.domain.Menu;

public interface MenuService {
    public List<List<Menu>> selectAll(int page,int limit);
    public int getcount();
    public void selectDel(String[] delmenu);
    public void change(int id,int menubarid,String name,double price,String status,String iid,String menubariid);
	public void insert(Integer id, Integer menubarid, String name, double price, String status);
}

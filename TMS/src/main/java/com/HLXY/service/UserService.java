package com.HLXY.service;


import com.HLXY.entity.Info;


public interface UserService {
	public String login();

	public Info Login_handle(String name, String password);
}

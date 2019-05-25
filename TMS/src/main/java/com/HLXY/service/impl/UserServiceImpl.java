package com.HLXY.service.impl;

import java.util.Calendar;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.HLXY.dao.InfoMapper;
import com.HLXY.entity.Info;
import com.HLXY.service.UserService;
import com.HLXY.util.CodeUtil;

@Service("userService")
public class UserServiceImpl implements UserService{
	private static final Logger LOGGER=LoggerFactory.getLogger(UserServiceImpl.class);
	@Resource
	private InfoMapper userdao;
	@Override
	public String login() {
		
		return null;
	}
/**
 * 登录校验处理
 */
	@Override
	public Info Login_handle(String userNum, String password) {
//			User use = userda.selectByPrimaryKey(1);
//			System.out.println(use.getId());          
			Info userInfo = userdao.getInfoByUserNum(Integer.parseInt(userNum));
			//System.out.println(GetSha1.getSha1(password));
			//System.out.println(user);// 测试成功返回正常
			if (userInfo != null && userInfo.getPassword().equals(CodeUtil.getSha1(password))) {
				LOGGER.info("UserServiceImpl.Login_handle.用户名是："+userInfo.getName()+"登录");
				userInfo.setLastLogin(Calendar.getInstance().getTime());
				userdao.updateByPrimaryKeySelective(userInfo);
				return userInfo;
			} else {
				return null;
			}		
	}

}
package com.ssm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.Dao.TypeInfoMapper;
import com.ssm.domain.TypeInfo;
import com.ssm.service.OrderService;



@Service("orderService")
public class OrderServiceImpl implements OrderService{
	@Resource
	private TypeInfoMapper type;

}

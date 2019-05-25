package com.HLXY.service;

import java.util.Map;

import com.HLXY.dto.NoticeReqDto;
import com.alibaba.fastjson.JSONArray;


public interface NoticeService {

	JSONArray notice_page(NoticeReqDto req);

	String notice_inf_change(NoticeReqDto req,Integer teacherNum);

	String notice_inf_del(String str, Integer teacherNum);

	Map<String, Object> select_one(Integer sessType, Integer id, Integer userId);

	Integer notice_page_count(NoticeReqDto req);


}

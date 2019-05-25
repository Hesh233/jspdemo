package com.HLXY.service;

import java.util.List;

import com.HLXY.dto.RecruitReqDto;
import com.HLXY.dto.RecruitResp;

import com.HLXY.entity.RecruitType;
import com.alibaba.fastjson.JSONArray;

public interface RecruitService {

	JSONArray recruit_page(RecruitReqDto req);

	String recruit_type_change(JSONArray jsonArray, Integer teacherNum);

	Integer recruit_page_count(Integer interviewType);

	String recruit_inf_change(JSONArray jsonArray, Integer teacherNum);

	Integer type_count();

	RecruitResp one_recruit(Integer id);

	String recruit_change(RecruitReqDto req);

	String recruit_add(RecruitReqDto req);

	String recruit_inf_del(String str, Integer teacherNum);

	String recruit_type_del(String str, Integer teacherNum);

	List<RecruitType> type_page(Integer page, Integer limit);

}

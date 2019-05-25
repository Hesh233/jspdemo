package com.HLXY.service;


import com.HLXY.dto.WeeklyHandleReqDto;
import com.HLXY.entity.Dirary;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public interface DayWeeklyService {

	String weekly_handle(WeeklyHandleReqDto reqDto);
	

	String teacher_appraise_handle(WeeklyHandleReqDto reqDto);

	JSONArray weeklyList(WeeklyHandleReqDto reqDto);




	Integer weeklyListCount(WeeklyHandleReqDto reqDto);


	JSONObject oneWeekly(WeeklyHandleReqDto reqDto);

	Dirary teaApprove(Integer id, Integer seTeacherNum);



	String guide_handle(WeeklyHandleReqDto req);


	JSONObject one_guide(WeeklyHandleReqDto req);


	JSONObject teacher_class(Integer teacherNum);

}

package com.HLXY.service;


import com.HLXY.dto.JobRespDto;
import com.HLXY.dto.StuJobReqDto;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public interface JobService {


	String teaAppoave(StuJobReqDto req);

	String stu_job_handle(StuJobReqDto req);

	JSONArray teaApproveList(StuJobReqDto req);

	JSONObject oneTeaApprove(StuJobReqDto req);

	JSONObject one_Stu(StuJobReqDto req);

	Integer teaApproveListCount(Integer teaNum);

	String approveInfChange(JSONArray jsonArray);

	JobRespDto one_Stu(Integer stuNum);


}

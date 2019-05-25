package com.HLXY.service;



import com.HLXY.dto.SourceReqDto;
import com.HLXY.dto.SourceRespdto;
import com.alibaba.fastjson.JSONArray;

public interface SourceConfirmService {


	String source_handle(SourceReqDto dto);

	JSONArray teacher_page(SourceReqDto req);

	Integer teacher_page_count(int teacherNum);

	String sourceInfChange(JSONArray jsonArray);

	SourceRespdto student_confirm_page(Integer studentNum);

}

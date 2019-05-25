package com.HLXY.dto;

import com.HLXY.entity.Source;
import com.HLXY.util.DateUtil;

public class SourceRespdto {
	public Integer id;

	public Integer studentNum;

	public String studentsResource;
    
	public String createTime;

	public String approve;
    public SourceRespdto(Source sou) {
    	studentNum = sou.getStudentNum();
    	studentsResource = sou.getStudentsResource();
    	createTime = DateUtil.format(sou.getCreateTime(), "yyyy-MM-dd");
    	if(sou.getApprove() == 0) {
    		approve = "未确认";
    	}else {
    		approve = "已确认";
    	}
    }
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(Integer studentNum) {
		this.studentNum = studentNum;
	}
	public String getstudentsResource() {
		return studentsResource;
	}
	public void setstudentsResource(String studentsResource) {
		this.studentsResource = studentsResource;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getApprove() {
		return approve;
	}
	public void setApprove(String approve) {
		this.approve = approve;
	}
    
}

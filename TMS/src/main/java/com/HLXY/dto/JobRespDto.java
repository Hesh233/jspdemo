package com.HLXY.dto;

import com.HLXY.entity.Job;
import com.HLXY.util.DateUtil;

public class JobRespDto {

    private Integer studentNum;

    private String companyName;

    private String companyAddress;

    private String createTime;

    private String confirmState;
    
    private String phoneNum;
    private String companyNum;
    //0未确认，1已确认
    public JobRespDto(Job job) {
    	studentNum = job.getStudentNum();
    	companyName = job.getCompanyName();
    	companyAddress = job.getCompanyAddress();
    	companyNum = job.getCompanyNum();
    	phoneNum = job.getPhoneNum();
    	createTime = DateUtil.format(job.getCreateTime(), "yyyy-MM-dd");
    	if(job.getConfirmState() == 0) {
    		confirmState = "未审批";
    	}else {
    		confirmState = "已审批";
    	}
    }

    
	public String getPhoneNum() {
		return phoneNum;
	}


	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}


	public String getCompanyNum() {
		return companyNum;
	}


	public void setCompanyNum(String companyNum) {
		this.companyNum = companyNum;
	}


	public Integer getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(Integer studentNum) {
		this.studentNum = studentNum;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getConfirmState() {
		return confirmState;
	}
	public void setConfirmState(String confirmState) {
		this.confirmState = confirmState;
	}
    
}

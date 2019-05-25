package com.HLXY.dto;
public class RecruitReqDto  extends PageSelectDto {
	public Integer interviewType;
	
	public Integer studentNum;

    public Integer teacherNum;
   
    public Integer userId;
    
    public String positionName;

    public String companyName;

    public String companyAddress;

    public String interviewPlace;

    public String startTime;

    public String endTime;

    public String remark;

	public Integer id;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
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

	public String getInterviewPlace() {
		return interviewPlace;
	}

	public void setInterviewPlace(String interviewPlace) {
		this.interviewPlace = interviewPlace;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(Integer studentNum) {
		this.studentNum = studentNum;
	}

	public Integer getTeacherNum() {
		return teacherNum;
	}

	public void setTeacherNum(Integer teacherNum) {
		this.teacherNum = teacherNum;
	}

	public Integer getInterviewType() {
		return interviewType;
	}

	public void setInterviewType(Integer interviewType) {
		this.interviewType = interviewType;
	}

	@Override
	public String toString() {
		return "RecruitReqDto [studentNum=" + studentNum + ", teacherNum=" + teacherNum + ", interviewType="
				+ interviewType + ", userId=" + userId + "]";
	}


}

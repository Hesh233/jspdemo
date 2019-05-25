package com.HLXY.dto;

public class NoticeReqDto extends PageSelectDto {
	public Integer sessType;
	public Integer  id;
	public Integer studentNum;//学生号
	public String title;
	public String entryeeInfo;
	public Integer teacherNum;//老师号
	public String startTime;
	public String endTime;
	public Integer type;
	
	public Integer getSessType() {
		return sessType;
	}
	public void setSessType(Integer sessType) {
		this.sessType = sessType;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEntryeeInfo() {
		return entryeeInfo;
	}
	public void setEntryeeInfo(String entryeeInfo) {
		this.entryeeInfo = entryeeInfo;
	}
	public Integer getTeacherNum() {
		return teacherNum;
	}
	public void setTeacherNum(Integer teacherNum) {
		this.teacherNum = teacherNum;
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
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "NoticeReqDto [id=" + id + ", studentNum=" + studentNum + ", title=" + title + ", entryeeInfo="
				+ entryeeInfo + ", teacherNum=" + teacherNum + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", type=" + type + "]";
	}
	
}

package com.HLXY.dto;

public class StudentConfirmReqDto extends PageSelectDto{
	public static final int NOT_CONFIRM = 0;
	public static final int CONFIRM = 1;
	public Integer studentNum;//学生号
	public String sourceInf;//生源地信息，不知道要有什么具体信息多个信息用;;隔开
	public Integer comfirm;//确认1否认0
	public Integer getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(Integer studentNum) {
		this.studentNum = studentNum;
	}
	public String getSourceInf() {
		return sourceInf;
	}
	public void setSourceInf(String sourceInf) {
		this.sourceInf = sourceInf;
	}
	public Integer getComfirm() {
		return comfirm;
	}
	public void setComfirm(Integer comfirm) {
		this.comfirm = comfirm;
	}
	public static int getNotConfirm() {
		return NOT_CONFIRM;
	}
	public static int getConfirm() {
		return CONFIRM;
	}
	
}

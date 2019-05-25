package com.HLXY.dto;


public class StuJobReqDto extends PageSelectDto{
	
	public String phoneNum;
    public String companyNum;
    public Integer studentNum;

    public String companyName;

    public String companyAddress;
    
    public Integer confirmState;
    
    public Integer teaNum;

    public String stuNums;
    
    public Integer weekNum;
    
    
    
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

	public Integer getWeekNum() {
		return weekNum;
	}

	public void setWeekNum(Integer weekNum) {
		this.weekNum = weekNum;
	}

	public String getStuNums() {
		return stuNums;
	}

	public void setStuNums(String stuNums) {
		this.stuNums = stuNums;
	}

	public Integer getTeaNum() {
		return teaNum;
	}

	public void setTeaNum(Integer teaNum) {
		this.teaNum = teaNum;
	}

	public Integer getConfirmState() {
		return confirmState;
	}

	public void setConfirmState(Integer confirmState) {
		this.confirmState = confirmState;
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

	@Override
	public String toString() {
		return "StuJobReqDto [studentNum=" + studentNum + ", companyName=" + companyName + ", companyAddress="
				+ companyAddress + ", confirmState=" + confirmState + ", teaNum=" + teaNum + ", stuNums=" + stuNums
				+ "]";
	}
    

}

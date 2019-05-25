package com.HLXY.dto;

import com.HLXY.entity.Recruit;
import com.HLXY.util.DateUtil;

public class RecruitResp {
	public String positionName;

	public String companyName;

	public String companyAddress;

	public String interviewPlace;

	public String startTime;

	public String endTime;

	public Integer interviewType;

	public String remark;
	
	public RecruitResp(Recruit r) {
		this.positionName = r.getPositionName();
		this.companyAddress = r.getCompanyAddress();
		this.companyName = r.getCompanyAddress();
		this.endTime = DateUtil.format(r.getEndTime(), "yyyy-MM-dd");
		this.startTime = DateUtil.format(r.getStartTime(), "yyyy-MM-dd");
		this.remark = r.getRemark();
		this.interviewPlace = r.getInterviewPlace();
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
		this.companyName = companyName == null ? null : companyName.trim();
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress == null ? null : companyAddress.trim();
	}



	public String getInterviewPlace() {
		return interviewPlace;
	}

	public void setInterviewPlace(String interviewPlace) {
		this.interviewPlace = interviewPlace == null ? null : interviewPlace.trim();
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

	public Integer getInterviewType() {
		return interviewType;
	}

	public void setInterviewType(Integer interviewType) {
		this.interviewType = interviewType;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	@Override
	public String toString() {
		return "Recruit [positionName=" + positionName + ", companyName=" + companyName
				+ ", companyAddress=" + companyAddress + ", interviewPlace="
				+ interviewPlace + ", startTime=" + startTime + ", endTime=" + endTime + ", interviewType="
				+ interviewType + ", remark=" + remark + "]";
	}
}

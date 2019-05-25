package com.HLXY.entity;

import java.io.Serializable;
import java.util.Date;

public class Job  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
    private String phoneNum;
    private String companyNum;
	private Integer id;

    private Integer studentNum;

    private String companyName;

    private String companyAddress;

    private Date createTime;

    private Integer confirmState;
    //0未确认，1已确认

    
    public Integer getId() {
        return id;
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

	public void setId(Integer id) {
        this.id = id;
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
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress == null ? null : companyAddress.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getConfirmState() {
        return confirmState;
    }

    public void setConfirmState(Integer confirmState) {
        this.confirmState = confirmState;
    }
}
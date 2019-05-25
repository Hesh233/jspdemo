package com.HLXY.entity;

import java.util.Date;

public class Notice {



	private Integer id;

    private Integer teacherId;
    private String title;

    private String entryeeInfo;

    private Date startTime;

    private Date endTime;
    
    private Integer type;
    
    

    public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }
    
    public String getEntryeeInfo() {
        return entryeeInfo;
    }

    public void setEntryeeInfo(String entryeeInfo) {
        this.entryeeInfo = entryeeInfo == null ? null : entryeeInfo.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
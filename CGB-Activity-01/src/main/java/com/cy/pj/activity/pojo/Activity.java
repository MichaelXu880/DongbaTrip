package com.cy.pj.activity.pojo;

import java.util.Date;

/**活动模块用于存储活动信息的一个对象*/
public class Activity {

	private Long id;
	private String title;
	private String category;
	private Date startTime;
	private Date endTime;
	private int state;
	private String remark;
	private Date createdTime;
	private String createdUser;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	@Override
	public String toString() {
		return "Activity [id=" + id + ", title=" + title + ", category=" + category + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", state=" + state + ", remark=" + remark + ", createdTime=" + createdTime
				+ ", createdUser=" + createdUser + "]";
	}
	
	 
}

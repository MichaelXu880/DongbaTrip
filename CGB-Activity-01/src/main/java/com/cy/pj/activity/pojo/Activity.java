package com.cy.pj.activity.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**活动模块用于存储活动信息的一个对象*/
@Data
public class Activity {

	private Long id;
	private String title;
	private String category;
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm")//setStartTime
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm")//getStartTime
	private Date startTime;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm")
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm")
	private Date endTime;
	private int state=1;
	private String remark;
	private Date createdTime;
	private String createdUser;
	
}

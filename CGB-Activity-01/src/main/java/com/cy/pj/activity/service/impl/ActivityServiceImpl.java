package com.cy.pj.activity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.pj.activity.dao.ActivityDao;
import com.cy.pj.activity.pojo.Activity;
import com.cy.pj.activity.service.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService {
	@Autowired
	private ActivityDao activityDao;
	
	@Override
	public int saveActivity(Activity entity) {
		// TODO Auto-generated method stub
		return activityDao.insertActivity(entity);
	}
	
	@Override
	public List<Activity> findActivitys() {
		//.....
		return activityDao.findActivitys();
	}

}




